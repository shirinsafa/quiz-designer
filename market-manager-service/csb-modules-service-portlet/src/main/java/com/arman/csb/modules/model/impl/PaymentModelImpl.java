package com.arman.csb.modules.model.impl;

import com.arman.csb.modules.model.Payment;
import com.arman.csb.modules.model.PaymentModel;
import com.arman.csb.modules.model.PaymentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Payment service. Represents a row in the &quot;CSBModules_Payment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.arman.csb.modules.model.PaymentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PaymentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentImpl
 * @see com.arman.csb.modules.model.Payment
 * @see com.arman.csb.modules.model.PaymentModel
 * @generated
 */
@JSON(strict = true)
public class PaymentModelImpl extends BaseModelImpl<Payment>
    implements PaymentModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a payment model instance should use the {@link com.arman.csb.modules.model.Payment} interface instead.
     */
    public static final String TABLE_NAME = "CSBModules_Payment";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "id_", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "description", Types.VARCHAR },
            { "card", Types.VARCHAR },
            { "amount", Types.BIGINT },
            { "status", Types.INTEGER },
            { "paymentDate", Types.TIMESTAMP },
            { "customerId", Types.BIGINT },
            { "factorId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table CSBModules_Payment (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null,card VARCHAR(75) null,amount LONG,status INTEGER,paymentDate DATE null,customerId LONG,factorId LONG)";
    public static final String TABLE_SQL_DROP = "drop table CSBModules_Payment";
    public static final String ORDER_BY_JPQL = " ORDER BY payment.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY CSBModules_Payment.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arman.csb.modules.model.Payment"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arman.csb.modules.model.Payment"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arman.csb.modules.model.Payment"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long CUSTOMERID_COLUMN_BITMASK = 2L;
    public static long FACTORID_COLUMN_BITMASK = 4L;
    public static long GROUPID_COLUMN_BITMASK = 8L;
    public static long UUID_COLUMN_BITMASK = 16L;
    public static long ID_COLUMN_BITMASK = 32L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arman.csb.modules.model.Payment"));
    private static ClassLoader _classLoader = Payment.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Payment.class
        };
    private String _uuid;
    private String _originalUuid;
    private long _id;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _description;
    private String _card;
    private long _amount;
    private int _status;
    private Date _paymentDate;
    private long _customerId;
    private long _originalCustomerId;
    private boolean _setOriginalCustomerId;
    private long _factorId;
    private long _originalFactorId;
    private boolean _setOriginalFactorId;
    private long _columnBitmask;
    private Payment _escapedModel;

    public PaymentModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Payment toModel(PaymentSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Payment model = new PaymentImpl();

        model.setUuid(soapModel.getUuid());
        model.setId(soapModel.getId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setDescription(soapModel.getDescription());
        model.setCard(soapModel.getCard());
        model.setAmount(soapModel.getAmount());
        model.setStatus(soapModel.getStatus());
        model.setPaymentDate(soapModel.getPaymentDate());
        model.setCustomerId(soapModel.getCustomerId());
        model.setFactorId(soapModel.getFactorId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Payment> toModels(PaymentSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Payment> models = new ArrayList<Payment>(soapModels.length);

        for (PaymentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Payment.class;
    }

    @Override
    public String getModelClassName() {
        return Payment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("description", getDescription());
        attributes.put("card", getCard());
        attributes.put("amount", getAmount());
        attributes.put("status", getStatus());
        attributes.put("paymentDate", getPaymentDate());
        attributes.put("customerId", getCustomerId());
        attributes.put("factorId", getFactorId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String card = (String) attributes.get("card");

        if (card != null) {
            setCard(card);
        }

        Long amount = (Long) attributes.get("amount");

        if (amount != null) {
            setAmount(amount);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date paymentDate = (Date) attributes.get("paymentDate");

        if (paymentDate != null) {
            setPaymentDate(paymentDate);
        }

        Long customerId = (Long) attributes.get("customerId");

        if (customerId != null) {
            setCustomerId(customerId);
        }

        Long factorId = (Long) attributes.get("factorId");

        if (factorId != null) {
            setFactorId(factorId);
        }
    }

    @JSON
    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public String getCard() {
        if (_card == null) {
            return StringPool.BLANK;
        } else {
            return _card;
        }
    }

    @Override
    public void setCard(String card) {
        _card = card;
    }

    @JSON
    @Override
    public long getAmount() {
        return _amount;
    }

    @Override
    public void setAmount(long amount) {
        _amount = amount;
    }

    @JSON
    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;
    }

    @JSON
    @Override
    public Date getPaymentDate() {
        return _paymentDate;
    }

    @Override
    public void setPaymentDate(Date paymentDate) {
        _paymentDate = paymentDate;
    }

    @JSON
    @Override
    public long getCustomerId() {
        return _customerId;
    }

    @Override
    public void setCustomerId(long customerId) {
        _columnBitmask |= CUSTOMERID_COLUMN_BITMASK;

        if (!_setOriginalCustomerId) {
            _setOriginalCustomerId = true;

            _originalCustomerId = _customerId;
        }

        _customerId = customerId;
    }

    public long getOriginalCustomerId() {
        return _originalCustomerId;
    }

    @JSON
    @Override
    public long getFactorId() {
        return _factorId;
    }

    @Override
    public void setFactorId(long factorId) {
        _columnBitmask |= FACTORID_COLUMN_BITMASK;

        if (!_setOriginalFactorId) {
            _setOriginalFactorId = true;

            _originalFactorId = _factorId;
        }

        _factorId = factorId;
    }

    public long getOriginalFactorId() {
        return _originalFactorId;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Payment.class.getName()));
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Payment.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Payment toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Payment) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        PaymentImpl paymentImpl = new PaymentImpl();

        paymentImpl.setUuid(getUuid());
        paymentImpl.setId(getId());
        paymentImpl.setGroupId(getGroupId());
        paymentImpl.setCompanyId(getCompanyId());
        paymentImpl.setUserId(getUserId());
        paymentImpl.setCreateDate(getCreateDate());
        paymentImpl.setModifiedDate(getModifiedDate());
        paymentImpl.setDescription(getDescription());
        paymentImpl.setCard(getCard());
        paymentImpl.setAmount(getAmount());
        paymentImpl.setStatus(getStatus());
        paymentImpl.setPaymentDate(getPaymentDate());
        paymentImpl.setCustomerId(getCustomerId());
        paymentImpl.setFactorId(getFactorId());

        paymentImpl.resetOriginalValues();

        return paymentImpl;
    }

    @Override
    public int compareTo(Payment payment) {
        long primaryKey = payment.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Payment)) {
            return false;
        }

        Payment payment = (Payment) obj;

        long primaryKey = payment.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        PaymentModelImpl paymentModelImpl = this;

        paymentModelImpl._originalUuid = paymentModelImpl._uuid;

        paymentModelImpl._originalGroupId = paymentModelImpl._groupId;

        paymentModelImpl._setOriginalGroupId = false;

        paymentModelImpl._originalCompanyId = paymentModelImpl._companyId;

        paymentModelImpl._setOriginalCompanyId = false;

        paymentModelImpl._originalCustomerId = paymentModelImpl._customerId;

        paymentModelImpl._setOriginalCustomerId = false;

        paymentModelImpl._originalFactorId = paymentModelImpl._factorId;

        paymentModelImpl._setOriginalFactorId = false;

        paymentModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Payment> toCacheModel() {
        PaymentCacheModel paymentCacheModel = new PaymentCacheModel();

        paymentCacheModel.uuid = getUuid();

        String uuid = paymentCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            paymentCacheModel.uuid = null;
        }

        paymentCacheModel.id = getId();

        paymentCacheModel.groupId = getGroupId();

        paymentCacheModel.companyId = getCompanyId();

        paymentCacheModel.userId = getUserId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            paymentCacheModel.createDate = createDate.getTime();
        } else {
            paymentCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            paymentCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            paymentCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        paymentCacheModel.description = getDescription();

        String description = paymentCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            paymentCacheModel.description = null;
        }

        paymentCacheModel.card = getCard();

        String card = paymentCacheModel.card;

        if ((card != null) && (card.length() == 0)) {
            paymentCacheModel.card = null;
        }

        paymentCacheModel.amount = getAmount();

        paymentCacheModel.status = getStatus();

        Date paymentDate = getPaymentDate();

        if (paymentDate != null) {
            paymentCacheModel.paymentDate = paymentDate.getTime();
        } else {
            paymentCacheModel.paymentDate = Long.MIN_VALUE;
        }

        paymentCacheModel.customerId = getCustomerId();

        paymentCacheModel.factorId = getFactorId();

        return paymentCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", card=");
        sb.append(getCard());
        sb.append(", amount=");
        sb.append(getAmount());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", paymentDate=");
        sb.append(getPaymentDate());
        sb.append(", customerId=");
        sb.append(getCustomerId());
        sb.append(", factorId=");
        sb.append(getFactorId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.modules.model.Payment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>card</column-name><column-value><![CDATA[");
        sb.append(getCard());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>amount</column-name><column-value><![CDATA[");
        sb.append(getAmount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>paymentDate</column-name><column-value><![CDATA[");
        sb.append(getPaymentDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>customerId</column-name><column-value><![CDATA[");
        sb.append(getCustomerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>factorId</column-name><column-value><![CDATA[");
        sb.append(getFactorId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
