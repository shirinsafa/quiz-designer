package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerLocalService
 * @generated
 */
public class CustomerLocalServiceWrapper implements CustomerLocalService,
    ServiceWrapper<CustomerLocalService> {
    private CustomerLocalService _customerLocalService;

    public CustomerLocalServiceWrapper(
        CustomerLocalService customerLocalService) {
        _customerLocalService = customerLocalService;
    }

    /**
    * Adds the customer to the database. Also notifies the appropriate model listeners.
    *
    * @param customer the customer
    * @return the customer that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer addCustomer(
        com.arman.csb.modules.model.Customer customer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.addCustomer(customer);
    }

    /**
    * Creates a new customer with the primary key. Does not add the customer to the database.
    *
    * @param id the primary key for the new customer
    * @return the new customer
    */
    @Override
    public com.arman.csb.modules.model.Customer createCustomer(long id) {
        return _customerLocalService.createCustomer(id);
    }

    /**
    * Deletes the customer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the customer
    * @return the customer that was removed
    * @throws PortalException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer deleteCustomer(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.deleteCustomer(id);
    }

    /**
    * Deletes the customer from the database. Also notifies the appropriate model listeners.
    *
    * @param customer the customer
    * @return the customer that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer deleteCustomer(
        com.arman.csb.modules.model.Customer customer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.deleteCustomer(customer);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _customerLocalService.dynamicQuery();
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.dynamicQueryCount(dynamicQuery);
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
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.arman.csb.modules.model.Customer fetchCustomer(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.fetchCustomer(id);
    }

    /**
    * Returns the customer with the matching UUID and company.
    *
    * @param uuid the customer's UUID
    * @param companyId the primary key of the company
    * @return the matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer fetchCustomerByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.fetchCustomerByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the customer matching the UUID and group.
    *
    * @param uuid the customer's UUID
    * @param groupId the primary key of the group
    * @return the matching customer, or <code>null</code> if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer fetchCustomerByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.fetchCustomerByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns the customer with the primary key.
    *
    * @param id the primary key of the customer
    * @return the customer
    * @throws PortalException if a customer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer getCustomer(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getCustomer(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the customer with the matching UUID and company.
    *
    * @param uuid the customer's UUID
    * @param companyId the primary key of the company
    * @return the matching customer
    * @throws PortalException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer getCustomerByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getCustomerByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the customer matching the UUID and group.
    *
    * @param uuid the customer's UUID
    * @param groupId the primary key of the group
    * @return the matching customer
    * @throws PortalException if a matching customer could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer getCustomerByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getCustomerByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the customers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of customers
    * @param end the upper bound of the range of customers (not inclusive)
    * @return the range of customers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arman.csb.modules.model.Customer> getCustomers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getCustomers(start, end);
    }

    /**
    * Returns the number of customers.
    *
    * @return the number of customers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCustomersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getCustomersCount();
    }

    /**
    * Updates the customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param customer the customer
    * @return the customer that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arman.csb.modules.model.Customer updateCustomer(
        com.arman.csb.modules.model.Customer customer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.updateCustomer(customer);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _customerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _customerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _customerLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addCustomer(
        java.util.Map<java.lang.String, java.lang.Object> customer,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.addCustomer(customer, serviceContext);
    }

    @Override
    public com.arman.csb.modules.model.Customer getById(
        java.lang.Long customerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.getById(customerId);
    }

    @Override
    public com.arman.csb.modules.model.Customer findByUserId(
        java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.findByUserId(userId);
    }

    @Override
    public int countByMentorCustomerId(java.lang.Long customerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.countByMentorCustomerId(customerId);
    }

    @Override
    public long count(java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.count(fromDate, toDate);
    }

    @Override
    public com.arman.csb.modules.model.Customer updateCustomer(
        com.arman.csb.modules.model.Customer customer,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _customerLocalService.updateCustomer(customer, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CustomerLocalService getWrappedCustomerLocalService() {
        return _customerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCustomerLocalService(
        CustomerLocalService customerLocalService) {
        _customerLocalService = customerLocalService;
    }

    @Override
    public CustomerLocalService getWrappedService() {
        return _customerLocalService;
    }

    @Override
    public void setWrappedService(CustomerLocalService customerLocalService) {
        _customerLocalService = customerLocalService;
    }
}