package com.arman.csb.modules.service.base;

import com.arman.csb.modules.model.Invoice;
import com.arman.csb.modules.service.InvoiceLocalService;
import com.arman.csb.modules.service.persistence.CustomerPersistence;
import com.arman.csb.modules.service.persistence.InvoiceItemPersistence;
import com.arman.csb.modules.service.persistence.InvoicePersistence;
import com.arman.csb.modules.service.persistence.PaymentPersistence;
import com.arman.csb.modules.service.persistence.ScorePersistence;
import com.arman.csb.modules.service.persistence.UserActivityPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the invoice local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.arman.csb.modules.service.impl.InvoiceLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.impl.InvoiceLocalServiceImpl
 * @see com.arman.csb.modules.service.InvoiceLocalServiceUtil
 * @generated
 */
public abstract class InvoiceLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements InvoiceLocalService, IdentifiableBean {
    @BeanReference(type = com.arman.csb.modules.service.CustomerLocalService.class)
    protected com.arman.csb.modules.service.CustomerLocalService customerLocalService;
    @BeanReference(type = com.arman.csb.modules.service.CustomerService.class)
    protected com.arman.csb.modules.service.CustomerService customerService;
    @BeanReference(type = CustomerPersistence.class)
    protected CustomerPersistence customerPersistence;
    @BeanReference(type = com.arman.csb.modules.service.InvoiceLocalService.class)
    protected com.arman.csb.modules.service.InvoiceLocalService invoiceLocalService;
    @BeanReference(type = com.arman.csb.modules.service.InvoiceService.class)
    protected com.arman.csb.modules.service.InvoiceService invoiceService;
    @BeanReference(type = InvoicePersistence.class)
    protected InvoicePersistence invoicePersistence;
    @BeanReference(type = com.arman.csb.modules.service.InvoiceItemLocalService.class)
    protected com.arman.csb.modules.service.InvoiceItemLocalService invoiceItemLocalService;
    @BeanReference(type = com.arman.csb.modules.service.InvoiceItemService.class)
    protected com.arman.csb.modules.service.InvoiceItemService invoiceItemService;
    @BeanReference(type = InvoiceItemPersistence.class)
    protected InvoiceItemPersistence invoiceItemPersistence;
    @BeanReference(type = com.arman.csb.modules.service.MyBlogLocalService.class)
    protected com.arman.csb.modules.service.MyBlogLocalService myBlogLocalService;
    @BeanReference(type = com.arman.csb.modules.service.MyBlogService.class)
    protected com.arman.csb.modules.service.MyBlogService myBlogService;
    @BeanReference(type = com.arman.csb.modules.service.MyDDLRecordLocalService.class)
    protected com.arman.csb.modules.service.MyDDLRecordLocalService myDDLRecordLocalService;
    @BeanReference(type = com.arman.csb.modules.service.MyDDLRecordService.class)
    protected com.arman.csb.modules.service.MyDDLRecordService myDDLRecordService;
    @BeanReference(type = com.arman.csb.modules.service.MyUserLocalService.class)
    protected com.arman.csb.modules.service.MyUserLocalService myUserLocalService;
    @BeanReference(type = com.arman.csb.modules.service.MyUserService.class)
    protected com.arman.csb.modules.service.MyUserService myUserService;
    @BeanReference(type = com.arman.csb.modules.service.PaymentLocalService.class)
    protected com.arman.csb.modules.service.PaymentLocalService paymentLocalService;
    @BeanReference(type = com.arman.csb.modules.service.PaymentService.class)
    protected com.arman.csb.modules.service.PaymentService paymentService;
    @BeanReference(type = PaymentPersistence.class)
    protected PaymentPersistence paymentPersistence;
    @BeanReference(type = com.arman.csb.modules.service.ScoreLocalService.class)
    protected com.arman.csb.modules.service.ScoreLocalService scoreLocalService;
    @BeanReference(type = com.arman.csb.modules.service.ScoreService.class)
    protected com.arman.csb.modules.service.ScoreService scoreService;
    @BeanReference(type = ScorePersistence.class)
    protected ScorePersistence scorePersistence;
    @BeanReference(type = com.arman.csb.modules.service.UserActivityLocalService.class)
    protected com.arman.csb.modules.service.UserActivityLocalService userActivityLocalService;
    @BeanReference(type = com.arman.csb.modules.service.UserActivityService.class)
    protected com.arman.csb.modules.service.UserActivityService userActivityService;
    @BeanReference(type = UserActivityPersistence.class)
    protected UserActivityPersistence userActivityPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private InvoiceLocalServiceClpInvoker _clpInvoker = new InvoiceLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.arman.csb.modules.service.InvoiceLocalServiceUtil} to access the invoice local service.
     */

    /**
     * Adds the invoice to the database. Also notifies the appropriate model listeners.
     *
     * @param invoice the invoice
     * @return the invoice that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Invoice addInvoice(Invoice invoice) throws SystemException {
        invoice.setNew(true);

        return invoicePersistence.update(invoice);
    }

    /**
     * Creates a new invoice with the primary key. Does not add the invoice to the database.
     *
     * @param id the primary key for the new invoice
     * @return the new invoice
     */
    @Override
    public Invoice createInvoice(long id) {
        return invoicePersistence.create(id);
    }

    /**
     * Deletes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the invoice
     * @return the invoice that was removed
     * @throws PortalException if a invoice with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Invoice deleteInvoice(long id)
        throws PortalException, SystemException {
        return invoicePersistence.remove(id);
    }

    /**
     * Deletes the invoice from the database. Also notifies the appropriate model listeners.
     *
     * @param invoice the invoice
     * @return the invoice that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Invoice deleteInvoice(Invoice invoice) throws SystemException {
        return invoicePersistence.remove(invoice);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Invoice.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return invoicePersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return invoicePersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return invoicePersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return invoicePersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return invoicePersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Invoice fetchInvoice(long id) throws SystemException {
        return invoicePersistence.fetchByPrimaryKey(id);
    }

    /**
     * Returns the invoice with the matching UUID and company.
     *
     * @param uuid the invoice's UUID
     * @param  companyId the primary key of the company
     * @return the matching invoice, or <code>null</code> if a matching invoice could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Invoice fetchInvoiceByUuidAndCompanyId(String uuid, long companyId)
        throws SystemException {
        return invoicePersistence.fetchByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the invoice matching the UUID and group.
     *
     * @param uuid the invoice's UUID
     * @param groupId the primary key of the group
     * @return the matching invoice, or <code>null</code> if a matching invoice could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Invoice fetchInvoiceByUuidAndGroupId(String uuid, long groupId)
        throws SystemException {
        return invoicePersistence.fetchByUUID_G(uuid, groupId);
    }

    /**
     * Returns the invoice with the primary key.
     *
     * @param id the primary key of the invoice
     * @return the invoice
     * @throws PortalException if a invoice with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Invoice getInvoice(long id) throws PortalException, SystemException {
        return invoicePersistence.findByPrimaryKey(id);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return invoicePersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns the invoice with the matching UUID and company.
     *
     * @param uuid the invoice's UUID
     * @param  companyId the primary key of the company
     * @return the matching invoice
     * @throws PortalException if a matching invoice could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Invoice getInvoiceByUuidAndCompanyId(String uuid, long companyId)
        throws PortalException, SystemException {
        return invoicePersistence.findByUuid_C_First(uuid, companyId, null);
    }

    /**
     * Returns the invoice matching the UUID and group.
     *
     * @param uuid the invoice's UUID
     * @param groupId the primary key of the group
     * @return the matching invoice
     * @throws PortalException if a matching invoice could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Invoice getInvoiceByUuidAndGroupId(String uuid, long groupId)
        throws PortalException, SystemException {
        return invoicePersistence.findByUUID_G(uuid, groupId);
    }

    /**
     * Returns a range of all the invoices.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of invoices
     * @param end the upper bound of the range of invoices (not inclusive)
     * @return the range of invoices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Invoice> getInvoices(int start, int end)
        throws SystemException {
        return invoicePersistence.findAll(start, end);
    }

    /**
     * Returns the number of invoices.
     *
     * @return the number of invoices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getInvoicesCount() throws SystemException {
        return invoicePersistence.countAll();
    }

    /**
     * Updates the invoice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param invoice the invoice
     * @return the invoice that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Invoice updateInvoice(Invoice invoice) throws SystemException {
        return invoicePersistence.update(invoice);
    }

    /**
     * Returns the customer local service.
     *
     * @return the customer local service
     */
    public com.arman.csb.modules.service.CustomerLocalService getCustomerLocalService() {
        return customerLocalService;
    }

    /**
     * Sets the customer local service.
     *
     * @param customerLocalService the customer local service
     */
    public void setCustomerLocalService(
        com.arman.csb.modules.service.CustomerLocalService customerLocalService) {
        this.customerLocalService = customerLocalService;
    }

    /**
     * Returns the customer remote service.
     *
     * @return the customer remote service
     */
    public com.arman.csb.modules.service.CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * Sets the customer remote service.
     *
     * @param customerService the customer remote service
     */
    public void setCustomerService(
        com.arman.csb.modules.service.CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Returns the customer persistence.
     *
     * @return the customer persistence
     */
    public CustomerPersistence getCustomerPersistence() {
        return customerPersistence;
    }

    /**
     * Sets the customer persistence.
     *
     * @param customerPersistence the customer persistence
     */
    public void setCustomerPersistence(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

    /**
     * Returns the invoice local service.
     *
     * @return the invoice local service
     */
    public com.arman.csb.modules.service.InvoiceLocalService getInvoiceLocalService() {
        return invoiceLocalService;
    }

    /**
     * Sets the invoice local service.
     *
     * @param invoiceLocalService the invoice local service
     */
    public void setInvoiceLocalService(
        com.arman.csb.modules.service.InvoiceLocalService invoiceLocalService) {
        this.invoiceLocalService = invoiceLocalService;
    }

    /**
     * Returns the invoice remote service.
     *
     * @return the invoice remote service
     */
    public com.arman.csb.modules.service.InvoiceService getInvoiceService() {
        return invoiceService;
    }

    /**
     * Sets the invoice remote service.
     *
     * @param invoiceService the invoice remote service
     */
    public void setInvoiceService(
        com.arman.csb.modules.service.InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    /**
     * Returns the invoice persistence.
     *
     * @return the invoice persistence
     */
    public InvoicePersistence getInvoicePersistence() {
        return invoicePersistence;
    }

    /**
     * Sets the invoice persistence.
     *
     * @param invoicePersistence the invoice persistence
     */
    public void setInvoicePersistence(InvoicePersistence invoicePersistence) {
        this.invoicePersistence = invoicePersistence;
    }

    /**
     * Returns the invoice item local service.
     *
     * @return the invoice item local service
     */
    public com.arman.csb.modules.service.InvoiceItemLocalService getInvoiceItemLocalService() {
        return invoiceItemLocalService;
    }

    /**
     * Sets the invoice item local service.
     *
     * @param invoiceItemLocalService the invoice item local service
     */
    public void setInvoiceItemLocalService(
        com.arman.csb.modules.service.InvoiceItemLocalService invoiceItemLocalService) {
        this.invoiceItemLocalService = invoiceItemLocalService;
    }

    /**
     * Returns the invoice item remote service.
     *
     * @return the invoice item remote service
     */
    public com.arman.csb.modules.service.InvoiceItemService getInvoiceItemService() {
        return invoiceItemService;
    }

    /**
     * Sets the invoice item remote service.
     *
     * @param invoiceItemService the invoice item remote service
     */
    public void setInvoiceItemService(
        com.arman.csb.modules.service.InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    /**
     * Returns the invoice item persistence.
     *
     * @return the invoice item persistence
     */
    public InvoiceItemPersistence getInvoiceItemPersistence() {
        return invoiceItemPersistence;
    }

    /**
     * Sets the invoice item persistence.
     *
     * @param invoiceItemPersistence the invoice item persistence
     */
    public void setInvoiceItemPersistence(
        InvoiceItemPersistence invoiceItemPersistence) {
        this.invoiceItemPersistence = invoiceItemPersistence;
    }

    /**
     * Returns the my blog local service.
     *
     * @return the my blog local service
     */
    public com.arman.csb.modules.service.MyBlogLocalService getMyBlogLocalService() {
        return myBlogLocalService;
    }

    /**
     * Sets the my blog local service.
     *
     * @param myBlogLocalService the my blog local service
     */
    public void setMyBlogLocalService(
        com.arman.csb.modules.service.MyBlogLocalService myBlogLocalService) {
        this.myBlogLocalService = myBlogLocalService;
    }

    /**
     * Returns the my blog remote service.
     *
     * @return the my blog remote service
     */
    public com.arman.csb.modules.service.MyBlogService getMyBlogService() {
        return myBlogService;
    }

    /**
     * Sets the my blog remote service.
     *
     * @param myBlogService the my blog remote service
     */
    public void setMyBlogService(
        com.arman.csb.modules.service.MyBlogService myBlogService) {
        this.myBlogService = myBlogService;
    }

    /**
     * Returns the my d d l record local service.
     *
     * @return the my d d l record local service
     */
    public com.arman.csb.modules.service.MyDDLRecordLocalService getMyDDLRecordLocalService() {
        return myDDLRecordLocalService;
    }

    /**
     * Sets the my d d l record local service.
     *
     * @param myDDLRecordLocalService the my d d l record local service
     */
    public void setMyDDLRecordLocalService(
        com.arman.csb.modules.service.MyDDLRecordLocalService myDDLRecordLocalService) {
        this.myDDLRecordLocalService = myDDLRecordLocalService;
    }

    /**
     * Returns the my d d l record remote service.
     *
     * @return the my d d l record remote service
     */
    public com.arman.csb.modules.service.MyDDLRecordService getMyDDLRecordService() {
        return myDDLRecordService;
    }

    /**
     * Sets the my d d l record remote service.
     *
     * @param myDDLRecordService the my d d l record remote service
     */
    public void setMyDDLRecordService(
        com.arman.csb.modules.service.MyDDLRecordService myDDLRecordService) {
        this.myDDLRecordService = myDDLRecordService;
    }

    /**
     * Returns the my user local service.
     *
     * @return the my user local service
     */
    public com.arman.csb.modules.service.MyUserLocalService getMyUserLocalService() {
        return myUserLocalService;
    }

    /**
     * Sets the my user local service.
     *
     * @param myUserLocalService the my user local service
     */
    public void setMyUserLocalService(
        com.arman.csb.modules.service.MyUserLocalService myUserLocalService) {
        this.myUserLocalService = myUserLocalService;
    }

    /**
     * Returns the my user remote service.
     *
     * @return the my user remote service
     */
    public com.arman.csb.modules.service.MyUserService getMyUserService() {
        return myUserService;
    }

    /**
     * Sets the my user remote service.
     *
     * @param myUserService the my user remote service
     */
    public void setMyUserService(
        com.arman.csb.modules.service.MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    /**
     * Returns the payment local service.
     *
     * @return the payment local service
     */
    public com.arman.csb.modules.service.PaymentLocalService getPaymentLocalService() {
        return paymentLocalService;
    }

    /**
     * Sets the payment local service.
     *
     * @param paymentLocalService the payment local service
     */
    public void setPaymentLocalService(
        com.arman.csb.modules.service.PaymentLocalService paymentLocalService) {
        this.paymentLocalService = paymentLocalService;
    }

    /**
     * Returns the payment remote service.
     *
     * @return the payment remote service
     */
    public com.arman.csb.modules.service.PaymentService getPaymentService() {
        return paymentService;
    }

    /**
     * Sets the payment remote service.
     *
     * @param paymentService the payment remote service
     */
    public void setPaymentService(
        com.arman.csb.modules.service.PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Returns the payment persistence.
     *
     * @return the payment persistence
     */
    public PaymentPersistence getPaymentPersistence() {
        return paymentPersistence;
    }

    /**
     * Sets the payment persistence.
     *
     * @param paymentPersistence the payment persistence
     */
    public void setPaymentPersistence(PaymentPersistence paymentPersistence) {
        this.paymentPersistence = paymentPersistence;
    }

    /**
     * Returns the score local service.
     *
     * @return the score local service
     */
    public com.arman.csb.modules.service.ScoreLocalService getScoreLocalService() {
        return scoreLocalService;
    }

    /**
     * Sets the score local service.
     *
     * @param scoreLocalService the score local service
     */
    public void setScoreLocalService(
        com.arman.csb.modules.service.ScoreLocalService scoreLocalService) {
        this.scoreLocalService = scoreLocalService;
    }

    /**
     * Returns the score remote service.
     *
     * @return the score remote service
     */
    public com.arman.csb.modules.service.ScoreService getScoreService() {
        return scoreService;
    }

    /**
     * Sets the score remote service.
     *
     * @param scoreService the score remote service
     */
    public void setScoreService(
        com.arman.csb.modules.service.ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    /**
     * Returns the score persistence.
     *
     * @return the score persistence
     */
    public ScorePersistence getScorePersistence() {
        return scorePersistence;
    }

    /**
     * Sets the score persistence.
     *
     * @param scorePersistence the score persistence
     */
    public void setScorePersistence(ScorePersistence scorePersistence) {
        this.scorePersistence = scorePersistence;
    }

    /**
     * Returns the user activity local service.
     *
     * @return the user activity local service
     */
    public com.arman.csb.modules.service.UserActivityLocalService getUserActivityLocalService() {
        return userActivityLocalService;
    }

    /**
     * Sets the user activity local service.
     *
     * @param userActivityLocalService the user activity local service
     */
    public void setUserActivityLocalService(
        com.arman.csb.modules.service.UserActivityLocalService userActivityLocalService) {
        this.userActivityLocalService = userActivityLocalService;
    }

    /**
     * Returns the user activity remote service.
     *
     * @return the user activity remote service
     */
    public com.arman.csb.modules.service.UserActivityService getUserActivityService() {
        return userActivityService;
    }

    /**
     * Sets the user activity remote service.
     *
     * @param userActivityService the user activity remote service
     */
    public void setUserActivityService(
        com.arman.csb.modules.service.UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    /**
     * Returns the user activity persistence.
     *
     * @return the user activity persistence
     */
    public UserActivityPersistence getUserActivityPersistence() {
        return userActivityPersistence;
    }

    /**
     * Sets the user activity persistence.
     *
     * @param userActivityPersistence the user activity persistence
     */
    public void setUserActivityPersistence(
        UserActivityPersistence userActivityPersistence) {
        this.userActivityPersistence = userActivityPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.arman.csb.modules.model.Invoice",
            invoiceLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.arman.csb.modules.model.Invoice");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Invoice.class;
    }

    protected String getModelClassName() {
        return Invoice.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = invoicePersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
