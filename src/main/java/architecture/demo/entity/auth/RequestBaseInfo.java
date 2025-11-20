package architecture.demo.entity.auth;

public class RequestBaseInfo {
    long ownerUserId;
    long userId;
    long tenantId;
    String fromName;
    String traceId;
    long originalOwnerId;
    long originalTenantId;
    String language;

    public RequestBaseInfo() {
    }

    public long getOriginalOwnerId() {
        return this.originalOwnerId;
    }

    public void setOriginalOwnerId(long originalOwnerId) {
        this.originalOwnerId = originalOwnerId;
    }

    public long getOriginalTenantId() {
        return this.originalTenantId;
    }

    public void setOriginalTenantId(long originalTenantId) {
        this.originalTenantId = originalTenantId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public long getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public long getOwnerUserId() {
        return this.ownerUserId;
    }

    public void setOwnerUserId(long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}