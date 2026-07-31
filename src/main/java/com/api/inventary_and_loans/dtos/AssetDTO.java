package com.api.inventary_and_loans.dtos;

public class AssetDTO {

    private Long id;
    private String name;
    private String category;
    private String status;
    private String assignedMemberName; // We only send the member name.

    public AssetDTO() {}

    // Getters y Setters (Another way using lombok)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedMemberName() { return assignedMemberName; }
    public void setAssignedMemberName(String assignedMemberName) { this.assignedMemberName = assignedMemberName; }
}