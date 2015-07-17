package com.recalot.views.data.sources;

import com.recalot.common.interfaces.controller.DataAccessController;
import com.recalot.views.common.AbstractWebActivator;
import com.recalot.views.common.GenericControllerHandler;
import com.recalot.views.common.HttpServiceTracker;
import com.recalot.views.common.WebService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ManagedService;

import java.util.Dictionary;
import java.util.Hashtable;


/**
 * @author Matthaeus.schmedding
 */
public class Activator extends AbstractWebActivator {

    /**
     * Implements BundleActivator.start(). Prints
     * a message and adds itself to the bundle context as a service
     * listener.
     *
     * @param context the framework context for the bundle.
     */
    @Override
    public void start(BundleContext context) {
        handler = new GenericControllerHandler<DataAccessController>(context, DataAccessController.class.getName());

        String pid = "com.recalot.views.data.sources";

        Dictionary config = new Hashtable();
        config.put(pid + ".path", new String("/sources"));

        service = new WebService(pid, context, new Servlet(handler), config);
        context.registerService(ManagedService.class.getName(), service, config);
        service.initialize();
    }
}