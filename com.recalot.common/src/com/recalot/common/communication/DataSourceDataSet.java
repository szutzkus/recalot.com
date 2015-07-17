package com.recalot.common.communication;

import com.recalot.common.exceptions.BaseException;
import com.recalot.common.interfaces.model.data.DataSource;

/**
 * @author Matthäus Schmedding (info@recalot.com)
 */
public class DataSourceDataSet implements DataSet {
    private DataSource dataSource;

    public DataSourceDataSet(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Interaction[] getInteractions()  throws BaseException {
        return dataSource.getInteractions();
    }

    @Override
    public Interaction[] getInteractions(String userId) throws BaseException {
        return dataSource.getInteractions(userId);
    }

    @Override
    public User getUser(String userId) throws BaseException {
        return dataSource.getUser(userId);
    }

    @Override
    public Item getItem(String itemId) throws BaseException {
        return dataSource.getItem(itemId);
    }

    public Item[] getItems() throws BaseException {
        return dataSource.getItems();
    }

    public User[] getUsers() throws BaseException {
        return dataSource.getUsers();
    }


    public int getItemsCount() {
        return dataSource.getItemsCount();
    }

    public int getUsersCount() {
        return dataSource.getUsersCount();
    }

    public int getInteractionsCount() {
        return dataSource.getInteractionsCount();
    }
}
