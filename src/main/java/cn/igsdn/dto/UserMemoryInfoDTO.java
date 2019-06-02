package cn.igsdn.dto;

public class UserMemoryInfoDTO {
    private String percentUsedMemory; // 已使用内存百分比
    private String totalMemory; // 总内存大小
    private String remainingMemory; // 剩余可用内存大小
    private Long documentTotal; // 文档总数
    private Long publicDocumentTotal; // 共享文档总数
    private Long privateDocumentTotal; // 私有文档总数

    public String getPercentUsedMemory() {
        return percentUsedMemory;
    }

    public void setPercentUsedMemory(String percentUsedMemory) {
        this.percentUsedMemory = percentUsedMemory;
    }

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getRemainingMemory() {
        return remainingMemory;
    }

    public void setRemainingMemory(String remainingMemory) {
        this.remainingMemory = remainingMemory;
    }

    public Long getDocumentTotal() {
        return documentTotal;
    }

    public void setDocumentTotal(Long documentTotal) {
        this.documentTotal = documentTotal;
    }

    public Long getPublicDocumentTotal() {
        return publicDocumentTotal;
    }

    public void setPublicDocumentTotal(Long publicDocumentTotal) {
        this.publicDocumentTotal = publicDocumentTotal;
    }

    public Long getPrivateDocumentTotal() {
        return privateDocumentTotal;
    }

    public void setPrivateDocumentTotal(Long privateDocumentTotal) {
        this.privateDocumentTotal = privateDocumentTotal;
    }
}
