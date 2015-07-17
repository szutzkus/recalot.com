package com.recalot.common.communication;

import com.recalot.common.exceptions.BaseException;
import com.recalot.common.interfaces.model.data.DataSource;

/**
 * @author Matthäus Schmedding (info@recalot.com)
 */
public interface DataSet {

    public Interaction[] getInteractions()  throws BaseException;
    public Interaction[] getInteractions(String userId)  throws BaseException;
    public User getUser(String userId) throws BaseException;
    public Item getItem(String itemId) throws BaseException;
    public Item[] getItems() throws BaseException;
    public User[] getUsers() throws BaseException;

    public int getItemsCount();

    public int getUsersCount();

    public int getInteractionsCount();
}
