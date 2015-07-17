package com.recalot.model.rec.access;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;



/**
 * @author Matthaeus.schmedding
 */
public class Activator implements BundleActivator {


    private RecommenderAccess access;

    /**
     * Implements BundleActivator.start(). Prints
     * a message and adds itself to the bundle context as a service
     * listener.
     *
     * @param context the framework context for the bundle.
     */
    public void start(BundleContext context) {
        access = new RecommenderAccess(context);
        context.registerService(com.recalot.common.interfaces.model.rec.RecommenderAccess.class.getName(), access, null);
    }

    /**
     * Implements BundleActivator.stop(). Prints
     * a message and removes itself from the bundle context as a
     * service listener.
     *
     * @param context the framework context for the bundle.
     */
    public void stop(BundleContext context) throws Exception {
        if(access != null) access.close();
    }
}