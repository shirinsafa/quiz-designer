package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.NoSuchCustomerException;
import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.model.impl.CustomerImpl;
import com.arman.csb.modules.model.impl.CustomerModelImpl;
import com.arman.csb.modules.service.persistence.CustomerPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerPersistence
 * @see CustomerUtil
 * @generated
 */
public class CustomerPersistenceImpl extends BasePersistenceImpl<Customer>
    implements CustomerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CustomerUtil} to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CustomerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            CustomerModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "customer.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "customer.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(customer.uuid IS NULL OR customer.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            CustomerModelImpl.UUID_COLUMN_BITMASK |
            CustomerModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "customer.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "customer.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(customer.uuid IS NULL OR customer.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "customer.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            CustomerModelImpl.UUID_COLUMN_BITMASK |
            CustomerModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "customer.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "customer.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(customer.uuid IS NULL OR customer.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "customer.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MENTOR = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMentor",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENTOR =
        new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMentor",
            new String[] { Long.class.getName() },
            CustomerModelImpl.MENTORCUSTOMERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MENTOR = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMentor",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_MENTOR_MENTORCUSTOMERID_2 = "customer.mentorCustomerId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, CustomerImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
            new String[] { Long.class.getName() },
            CustomerModelImpl.CUSTOMERUSERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_CUSTOMERUSERID_2 = "customer.customerUserId = ?";
    private static final String _SQL_SELECT_CUSTOMER = "SELECT customer FROM Customer customer";
    private static final String _SQL_SELECT_CUSTOMER_WHERE = "SELECT customer FROM Customer customer WHERE ";
    private static final String _SQL_COUNT_CUSTOMER = "SELECT COUNT(customer) FROM Customer customer";
    private static final String _SQL_COUNT_CUSTOMER_WHERE = "SELECT COUNT(customer) FROM Customer customer WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "customer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Customer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Customer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CustomerPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id"
            });
    private static Customer _nullCustomer = new CustomerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Customer> toCacheModel() {
                return _nullCustomerCacheModel;
            }
        };

    private static CacheModel<Customer> _nullCustomerCacheModel = new CacheModel<Customer>() {
            @Override
            public Customer toEntityModel() {
                return _nullCustomer;
            }
        };

    public CustomerPersistenceImpl() {
        setModelClass(Customer.class);
    }

    /**
     * Returns all the customers where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the customers where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @return the range of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the customers where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Customer> list = (List<Customer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Customer customer : list) {
                if (!Validator.equals(uuid, customer.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CUSTOMER_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CustomerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Customer>(list);
                } else {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first customer in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByUuid_First(uuid, orderByComparator);

        if (customer != null) {
            return customer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCustomerException(msg.toString());
    }

    /**
     * Returns the first customer in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Customer> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last customer in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByUuid_Last(uuid, orderByComparator);

        if (customer != null) {
            return customer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCustomerException(msg.toString());
    }

    /**
     * Returns the last customer in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Customer> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the customers before and after the current customer in the ordered set where uuid = &#63;.
     *
     * @param id the primary key of the current customer
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Customer[] array = new CustomerImpl[3];

            array[0] = getByUuid_PrevAndNext(session, customer, uuid,
                    orderByComparator, true);

            array[1] = customer;

            array[2] = getByUuid_PrevAndNext(session, customer, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Customer getByUuid_PrevAndNext(Session session,
        Customer customer, String uuid, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CUSTOMER_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CustomerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(customer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Customer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the customers where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Customer customer : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(customer);
        }
    }

    /**
     * Returns the number of customers where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CUSTOMER_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the customer where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchCustomerException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByUUID_G(String uuid, long groupId)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByUUID_G(uuid, groupId);

        if (customer == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCustomerException(msg.toString());
        }

        return customer;
    }

    /**
     * Returns the customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the customer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Customer) {
            Customer customer = (Customer) result;

            if (!Validator.equals(uuid, customer.getUuid()) ||
                    (groupId != customer.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_CUSTOMER_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Customer> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Customer customer = list.get(0);

                    result = customer;

                    cacheResult(customer);

                    if ((customer.getUuid() == null) ||
                            !customer.getUuid().equals(uuid) ||
                            (customer.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, customer);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Customer) result;
        }
    }

    /**
     * Removes the customer where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the customer that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer removeByUUID_G(String uuid, long groupId)
        throws NoSuchCustomerException, SystemException {
        Customer customer = findByUUID_G(uuid, groupId);

        return remove(customer);
    }

    /**
     * Returns the number of customers where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CUSTOMER_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the customers where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the customers where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @return the range of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the customers where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Customer> list = (List<Customer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Customer customer : list) {
                if (!Validator.equals(uuid, customer.getUuid()) ||
                        (companyId != customer.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_CUSTOMER_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CustomerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Customer>(list);
                } else {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first customer in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (customer != null) {
            return customer;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCustomerException(msg.toString());
    }

    /**
     * Returns the first customer in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Customer> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last customer in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (customer != null) {
            return customer;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCustomerException(msg.toString());
    }

    /**
     * Returns the last customer in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Customer> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the customers before and after the current customer in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param id the primary key of the current customer
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer[] findByUuid_C_PrevAndNext(long id, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Customer[] array = new CustomerImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, customer, uuid,
                    companyId, orderByComparator, true);

            array[1] = customer;

            array[2] = getByUuid_C_PrevAndNext(session, customer, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Customer getByUuid_C_PrevAndNext(Session session,
        Customer customer, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CUSTOMER_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CustomerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(customer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Customer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the customers where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Customer customer : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(customer);
        }
    }

    /**
     * Returns the number of customers where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CUSTOMER_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the customers where mentorCustomerId = &#63;.
     *
     * @param mentorCustomerId the mentor customer ID
     * @return the matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByMentor(long mentorCustomerId)
        throws SystemException {
        return findByMentor(mentorCustomerId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the customers where mentorCustomerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param mentorCustomerId the mentor customer ID
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @return the range of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByMentor(long mentorCustomerId, int start, int end)
        throws SystemException {
        return findByMentor(mentorCustomerId, start, end, null);
    }

    /**
     * Returns an ordered range of all the customers where mentorCustomerId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param mentorCustomerId the mentor customer ID
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findByMentor(long mentorCustomerId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENTOR;
            finderArgs = new Object[] { mentorCustomerId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MENTOR;
            finderArgs = new Object[] {
                    mentorCustomerId,
                    
                    start, end, orderByComparator
                };
        }

        List<Customer> list = (List<Customer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Customer customer : list) {
                if ((mentorCustomerId != customer.getMentorCustomerId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CUSTOMER_WHERE);

            query.append(_FINDER_COLUMN_MENTOR_MENTORCUSTOMERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CustomerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mentorCustomerId);

                if (!pagination) {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Customer>(list);
                } else {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first customer in the ordered set where mentorCustomerId = &#63;.
     *
     * @param mentorCustomerId the mentor customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByMentor_First(long mentorCustomerId,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByMentor_First(mentorCustomerId,
                orderByComparator);

        if (customer != null) {
            return customer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("mentorCustomerId=");
        msg.append(mentorCustomerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCustomerException(msg.toString());
    }

    /**
     * Returns the first customer in the ordered set where mentorCustomerId = &#63;.
     *
     * @param mentorCustomerId the mentor customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByMentor_First(long mentorCustomerId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Customer> list = findByMentor(mentorCustomerId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last customer in the ordered set where mentorCustomerId = &#63;.
     *
     * @param mentorCustomerId the mentor customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByMentor_Last(long mentorCustomerId,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByMentor_Last(mentorCustomerId,
                orderByComparator);

        if (customer != null) {
            return customer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("mentorCustomerId=");
        msg.append(mentorCustomerId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCustomerException(msg.toString());
    }

    /**
     * Returns the last customer in the ordered set where mentorCustomerId = &#63;.
     *
     * @param mentorCustomerId the mentor customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByMentor_Last(long mentorCustomerId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByMentor(mentorCustomerId);

        if (count == 0) {
            return null;
        }

        List<Customer> list = findByMentor(mentorCustomerId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the customers before and after the current customer in the ordered set where mentorCustomerId = &#63;.
     *
     * @param id the primary key of the current customer
     * @param mentorCustomerId the mentor customer ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer[] findByMentor_PrevAndNext(long id, long mentorCustomerId,
        OrderByComparator orderByComparator)
        throws NoSuchCustomerException, SystemException {
        Customer customer = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Customer[] array = new CustomerImpl[3];

            array[0] = getByMentor_PrevAndNext(session, customer,
                    mentorCustomerId, orderByComparator, true);

            array[1] = customer;

            array[2] = getByMentor_PrevAndNext(session, customer,
                    mentorCustomerId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Customer getByMentor_PrevAndNext(Session session,
        Customer customer, long mentorCustomerId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CUSTOMER_WHERE);

        query.append(_FINDER_COLUMN_MENTOR_MENTORCUSTOMERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CustomerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(mentorCustomerId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(customer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Customer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the customers where mentorCustomerId = &#63; from the database.
     *
     * @param mentorCustomerId the mentor customer ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByMentor(long mentorCustomerId) throws SystemException {
        for (Customer customer : findByMentor(mentorCustomerId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(customer);
        }
    }

    /**
     * Returns the number of customers where mentorCustomerId = &#63;.
     *
     * @param mentorCustomerId the mentor customer ID
     * @return the number of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByMentor(long mentorCustomerId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_MENTOR;

        Object[] finderArgs = new Object[] { mentorCustomerId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CUSTOMER_WHERE);

            query.append(_FINDER_COLUMN_MENTOR_MENTORCUSTOMERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mentorCustomerId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the customer where customerUserId = &#63; or throws a {@link com.arman.csb.modules.NoSuchCustomerException} if it could not be found.
     *
     * @param customerUserId the customer user ID
     * @return the matching customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByUserId(long customerUserId)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByUserId(customerUserId);

        if (customer == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("customerUserId=");
            msg.append(customerUserId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCustomerException(msg.toString());
        }

        return customer;
    }

    /**
     * Returns the customer where customerUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param customerUserId the customer user ID
     * @return the matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUserId(long customerUserId)
        throws SystemException {
        return fetchByUserId(customerUserId, true);
    }

    /**
     * Returns the customer where customerUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param customerUserId the customer user ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching customer, or <code>null</code> if a matching customer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByUserId(long customerUserId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { customerUserId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs, this);
        }

        if (result instanceof Customer) {
            Customer customer = (Customer) result;

            if ((customerUserId != customer.getCustomerUserId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_CUSTOMER_WHERE);

            query.append(_FINDER_COLUMN_USERID_CUSTOMERUSERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerUserId);

                List<Customer> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "CustomerPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Customer customer = list.get(0);

                    result = customer;

                    cacheResult(customer);

                    if ((customer.getCustomerUserId() != customerUserId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                            finderArgs, customer);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Customer) result;
        }
    }

    /**
     * Removes the customer where customerUserId = &#63; from the database.
     *
     * @param customerUserId the customer user ID
     * @return the customer that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer removeByUserId(long customerUserId)
        throws NoSuchCustomerException, SystemException {
        Customer customer = findByUserId(customerUserId);

        return remove(customer);
    }

    /**
     * Returns the number of customers where customerUserId = &#63;.
     *
     * @param customerUserId the customer user ID
     * @return the number of matching customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long customerUserId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { customerUserId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CUSTOMER_WHERE);

            query.append(_FINDER_COLUMN_USERID_CUSTOMERUSERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(customerUserId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the customer in the entity cache if it is enabled.
     *
     * @param customer the customer
     */
    @Override
    public void cacheResult(Customer customer) {
        EntityCacheUtil.putResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerImpl.class, customer.getPrimaryKey(), customer);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { customer.getUuid(), customer.getGroupId() }, customer);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
            new Object[] { customer.getCustomerUserId() }, customer);

        customer.resetOriginalValues();
    }

    /**
     * Caches the customers in the entity cache if it is enabled.
     *
     * @param customers the customers
     */
    @Override
    public void cacheResult(List<Customer> customers) {
        for (Customer customer : customers) {
            if (EntityCacheUtil.getResult(
                        CustomerModelImpl.ENTITY_CACHE_ENABLED,
                        CustomerImpl.class, customer.getPrimaryKey()) == null) {
                cacheResult(customer);
            } else {
                customer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all customers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CustomerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CustomerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the customer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Customer customer) {
        EntityCacheUtil.removeResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerImpl.class, customer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(customer);
    }

    @Override
    public void clearCache(List<Customer> customers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Customer customer : customers) {
            EntityCacheUtil.removeResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
                CustomerImpl.class, customer.getPrimaryKey());

            clearUniqueFindersCache(customer);
        }
    }

    protected void cacheUniqueFindersCache(Customer customer) {
        if (customer.isNew()) {
            Object[] args = new Object[] {
                    customer.getUuid(), customer.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                customer);

            args = new Object[] { customer.getCustomerUserId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
                customer);
        } else {
            CustomerModelImpl customerModelImpl = (CustomerModelImpl) customer;

            if ((customerModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        customer.getUuid(), customer.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    customer);
            }

            if ((customerModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { customer.getCustomerUserId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
                    customer);
            }
        }
    }

    protected void clearUniqueFindersCache(Customer customer) {
        CustomerModelImpl customerModelImpl = (CustomerModelImpl) customer;

        Object[] args = new Object[] { customer.getUuid(), customer.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((customerModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    customerModelImpl.getOriginalUuid(),
                    customerModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }

        args = new Object[] { customer.getCustomerUserId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

        if ((customerModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
            args = new Object[] { customerModelImpl.getOriginalCustomerUserId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
        }
    }

    /**
     * Creates a new customer with the primary key. Does not add the customer to the database.
     *
     * @param id the primary key for the new customer
     * @return the new customer
     */
    @Override
    public Customer create(long id) {
        Customer customer = new CustomerImpl();

        customer.setNew(true);
        customer.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        customer.setUuid(uuid);

        return customer;
    }

    /**
     * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the customer
     * @return the customer that was removed
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer remove(long id)
        throws NoSuchCustomerException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the customer
     * @return the customer that was removed
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer remove(Serializable primaryKey)
        throws NoSuchCustomerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Customer customer = (Customer) session.get(CustomerImpl.class,
                    primaryKey);

            if (customer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(customer);
        } catch (NoSuchCustomerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Customer removeImpl(Customer customer) throws SystemException {
        customer = toUnwrappedModel(customer);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(customer)) {
                customer = (Customer) session.get(CustomerImpl.class,
                        customer.getPrimaryKeyObj());
            }

            if (customer != null) {
                session.delete(customer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (customer != null) {
            clearCache(customer);
        }

        return customer;
    }

    @Override
    public Customer updateImpl(com.arman.csb.modules.model.Customer customer)
        throws SystemException {
        customer = toUnwrappedModel(customer);

        boolean isNew = customer.isNew();

        CustomerModelImpl customerModelImpl = (CustomerModelImpl) customer;

        if (Validator.isNull(customer.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            customer.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (customer.isNew()) {
                session.save(customer);

                customer.setNew(false);
            } else {
                session.merge(customer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CustomerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((customerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { customerModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { customerModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((customerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        customerModelImpl.getOriginalUuid(),
                        customerModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        customerModelImpl.getUuid(),
                        customerModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((customerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENTOR.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        customerModelImpl.getOriginalMentorCustomerId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MENTOR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENTOR,
                    args);

                args = new Object[] { customerModelImpl.getMentorCustomerId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MENTOR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MENTOR,
                    args);
            }
        }

        EntityCacheUtil.putResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
            CustomerImpl.class, customer.getPrimaryKey(), customer);

        clearUniqueFindersCache(customer);
        cacheUniqueFindersCache(customer);

        return customer;
    }

    protected Customer toUnwrappedModel(Customer customer) {
        if (customer instanceof CustomerImpl) {
            return customer;
        }

        CustomerImpl customerImpl = new CustomerImpl();

        customerImpl.setNew(customer.isNew());
        customerImpl.setPrimaryKey(customer.getPrimaryKey());

        customerImpl.setUuid(customer.getUuid());
        customerImpl.setId(customer.getId());
        customerImpl.setGroupId(customer.getGroupId());
        customerImpl.setCompanyId(customer.getCompanyId());
        customerImpl.setUserId(customer.getUserId());
        customerImpl.setUserName(customer.getUserName());
        customerImpl.setCreateDate(customer.getCreateDate());
        customerImpl.setModifiedDate(customer.getModifiedDate());
        customerImpl.setName(customer.getName());
        customerImpl.setFirstName(customer.getFirstName());
        customerImpl.setLastName(customer.getLastName());
        customerImpl.setMobile(customer.getMobile());
        customerImpl.setNationalCode(customer.getNationalCode());
        customerImpl.setEmail(customer.getEmail());
        customerImpl.setCard(customer.getCard());
        customerImpl.setScore(customer.getScore());
        customerImpl.setStatus(customer.getStatus());
        customerImpl.setCustomerUserId(customer.getCustomerUserId());
        customerImpl.setMentorCustomerId(customer.getMentorCustomerId());

        return customerImpl;
    }

    /**
     * Returns the customer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the customer
     * @return the customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCustomerException, SystemException {
        Customer customer = fetchByPrimaryKey(primaryKey);

        if (customer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return customer;
    }

    /**
     * Returns the customer with the primary key or throws a {@link com.arman.csb.modules.NoSuchCustomerException} if it could not be found.
     *
     * @param id the primary key of the customer
     * @return the customer
     * @throws com.arman.csb.modules.NoSuchCustomerException if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer findByPrimaryKey(long id)
        throws NoSuchCustomerException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the customer
     * @return the customer, or <code>null</code> if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Customer customer = (Customer) EntityCacheUtil.getResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
                CustomerImpl.class, primaryKey);

        if (customer == _nullCustomer) {
            return null;
        }

        if (customer == null) {
            Session session = null;

            try {
                session = openSession();

                customer = (Customer) session.get(CustomerImpl.class, primaryKey);

                if (customer != null) {
                    cacheResult(customer);
                } else {
                    EntityCacheUtil.putResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
                        CustomerImpl.class, primaryKey, _nullCustomer);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CustomerModelImpl.ENTITY_CACHE_ENABLED,
                    CustomerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return customer;
    }

    /**
     * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the customer
     * @return the customer, or <code>null</code> if a customer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Customer fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the customers.
     *
     * @return the customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Customer> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the customers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.CustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of customers
     * @param end the upper bound of the range of customers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Customer> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Customer> list = (List<Customer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CUSTOMER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CUSTOMER;

                if (pagination) {
                    sql = sql.concat(CustomerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Customer>(list);
                } else {
                    list = (List<Customer>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the customers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Customer customer : findAll()) {
            remove(customer);
        }
    }

    /**
     * Returns the number of customers.
     *
     * @return the number of customers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CUSTOMER);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the customer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arman.csb.modules.model.Customer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Customer>> listenersList = new ArrayList<ModelListener<Customer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Customer>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CustomerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}