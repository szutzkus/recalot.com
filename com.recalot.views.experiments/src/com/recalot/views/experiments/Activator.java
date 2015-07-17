package com.recalot.views.experiments;

import com.recalot.common.interfaces.controller.ExperimentsController;
import com.recalot.views.common.AbstractWebActivator;
import com.recalot.views.common.GenericControllerHandler;
import com.recalot.views.common.WebService;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ManagedService;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * @author Matthaeus.schmedding
 */
public class Activator extends AbstractWebActivator {

    @Override
    public void start(BundleContext context) {
        handler = new GenericControllerHandler<ExperimentsController>(context, ExperimentsController.class.getName());

        String pid = "com.recalot.views.recommend.experiments";

        Dictionary config = new Hashtable();
        config.put(pid + ".path", new String("/experiments"));

        service = new WebService(pid, context, new Servlet(handler), config);
        context.registerService(ManagedService.class.getName(), service, config);
        service.initialize();
    }
}
