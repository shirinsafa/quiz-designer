package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.InvoiceItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the invoice item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItemPersistenceImpl
 * @see InvoiceItemUtil
 * @generated
 */
public interface InvoiceItemPersistence extends BasePersistence<InvoiceItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link InvoiceItemUtil} to access the invoice item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the invoice items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the invoice items where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @return the range of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the invoice items where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last invoice item in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the invoice items before and after the current invoice item in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current invoice item
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the invoice items where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of invoice items where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the invoice item where invoiceId = &#63; or throws a {@link com.arman.csb.modules.NoSuchInvoiceItemException} if it could not be found.
    *
    * @param invoiceId the invoice ID
    * @return the matching invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem findByInvoiceId(
        long invoiceId)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the invoice item where invoiceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param invoiceId the invoice ID
    * @return the matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem fetchByInvoiceId(
        long invoiceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the invoice item where invoiceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param invoiceId the invoice ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching invoice item, or <code>null</code> if a matching invoice item could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem fetchByInvoiceId(
        long invoiceId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the invoice item where invoiceId = &#63; from the database.
    *
    * @param invoiceId the invoice ID
    * @return the invoice item that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem removeByInvoiceId(
        long invoiceId)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of invoice items where invoiceId = &#63;.
    *
    * @param invoiceId the invoice ID
    * @return the number of matching invoice items
    * @throws SystemException if a system exception occurred
    */
    public int countByInvoiceId(long invoiceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the invoice item in the entity cache if it is enabled.
    *
    * @param invoiceItem the invoice item
    */
    public void cacheResult(com.arman.csb.modules.model.InvoiceItem invoiceItem);

    /**
    * Caches the invoice items in the entity cache if it is enabled.
    *
    * @param invoiceItems the invoice items
    */
    public void cacheResult(
        java.util.List<com.arman.csb.modules.model.InvoiceItem> invoiceItems);

    /**
    * Creates a new invoice item with the primary key. Does not add the invoice item to the database.
    *
    * @param id the primary key for the new invoice item
    * @return the new invoice item
    */
    public com.arman.csb.modules.model.InvoiceItem create(long id);

    /**
    * Removes the invoice item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item that was removed
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem remove(long id)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.modules.model.InvoiceItem updateImpl(
        com.arman.csb.modules.model.InvoiceItem invoiceItem)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the invoice item with the primary key or throws a {@link com.arman.csb.modules.NoSuchInvoiceItemException} if it could not be found.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item
    * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchInvoiceItemException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the invoice item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the invoice item
    * @return the invoice item, or <code>null</code> if a invoice item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.InvoiceItem fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the invoice items.
    *
    * @return the invoice items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the invoice items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @return the range of invoice items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the invoice items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of invoice items
    * @param end the upper bound of the range of invoice items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of invoice items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.InvoiceItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the invoice items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of invoice items.
    *
    * @return the number of invoice items
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}