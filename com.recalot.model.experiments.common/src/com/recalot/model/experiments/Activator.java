package com.recalot.model.experiments;


import com.recalot.common.configuration.ConfigurationItem;
import com.recalot.common.interfaces.model.experiment.DataSplitter;
import com.recalot.model.experiments.access.ExperimentAccess;
import com.recalot.model.experiments.splitter.RandomDataSplitter;
import com.recalot.model.experiments.splitter.TimeBasedDataSplitter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.ArrayList;


/**
 * @author Matthaeus.schmedding
 */
public class Activator implements BundleActivator {


    private ExperimentAccess access;
    private ArrayList<DataSplitter> splitters;

    /**
     * Implements BundleActivator.start(). Prints
     * a message and adds itself to the bundle context as a service
     * listener.
     *
     * @param context the framework context for the bundle.
     */
    public void start(BundleContext context) {
        access = new ExperimentAccess(context);
        context.registerService(com.recalot.common.interfaces.model.experiment.ExperimentAccess.class.getName(), access, null);

        splitters = new ArrayList<>();

        RandomDataSplitter randomDataSplitter = new RandomDataSplitter();

        randomDataSplitter.setConfiguration(new ConfigurationItem("minRatingsPerUser", ConfigurationItem.ConfigurationItemType.Integer, "-1", ConfigurationItem.ConfigurationItemRequirementType.Optional));
        randomDataSplitter.setConfiguration(new ConfigurationItem("minRatingsPerItem", ConfigurationItem.ConfigurationItemType.Integer, "-1", ConfigurationItem.ConfigurationItemRequirementType.Optional));
        randomDataSplitter.setConfiguration(new ConfigurationItem("nbFolds", ConfigurationItem.ConfigurationItemType.Integer, "2", ConfigurationItem.ConfigurationItemRequirementType.Optional));
        randomDataSplitter.setConfiguration(new ConfigurationItem("globalRandomSplit", ConfigurationItem.ConfigurationItemType.Boolean, "true", ConfigurationItem.ConfigurationItemRequirementType.Optional));


        TimeBasedDataSplitter timeBasedSplitter = new TimeBasedDataSplitter();

        timeBasedSplitter.setConfiguration(new ConfigurationItem("minRatingsPerUser", ConfigurationItem.ConfigurationItemType.Integer, "-1", ConfigurationItem.ConfigurationItemRequirementType.Optional));
        timeBasedSplitter.setConfiguration(new ConfigurationItem("minRatingsPerItem", ConfigurationItem.ConfigurationItemType.Integer, "-1", ConfigurationItem.ConfigurationItemRequirementType.Optional));
        timeBasedSplitter.setConfiguration(new ConfigurationItem("nbFolds", ConfigurationItem.ConfigurationItemType.Integer, "2", ConfigurationItem.ConfigurationItemRequirementType.Optional));
        timeBasedSplitter.setConfiguration(new ConfigurationItem("globalRandomSplit", ConfigurationItem.ConfigurationItemType.Boolean, "true", ConfigurationItem.ConfigurationItemRequirementType.Optional));

        splitters.add(randomDataSplitter);
        splitters.add(timeBasedSplitter);

        for (DataSplitter splitter : splitters) {
            context.registerService(DataSplitter.class.getName(), splitter, null);
        }
    }

    /**
     * Implements BundleActivator.stop(). Prints
     * a message and removes itself from the bundle context as a
     * service listener.
     *
     * @param context the framework context for the bundle.
     */
    public void stop(BundleContext context) throws Exception {
        if (access != null) {
            access.close();
            access = null;
        }

        if (splitters != null) {
            for (DataSplitter splitter : splitters) {
                splitter.close();
            }

            splitters = null;
        }
    }
}