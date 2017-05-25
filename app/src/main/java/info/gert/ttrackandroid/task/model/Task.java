package info.gert.ttrackandroid.task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("emailOfClient")
    @Expose
    private String emailOfClient;
    @SerializedName("phoneOfClient")
    @Expose
    private String phoneOfClient;
    @SerializedName("startOfTheRout")
    @Expose
    private String startOfTheRout;
    @SerializedName("endOfRoutLocation")
    @Expose
    private String endOfRoutLocation;
    @SerializedName("startOfRoutLocation")
    @Expose
    private String startOfRoutLocation;
    @SerializedName("endOfTheRout")
    @Expose
    private String endOfTheRout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEmailOfClient() {
        return emailOfClient;
    }

    public void setEmailOfClient(String emailOfClient) {
        this.emailOfClient = emailOfClient;
    }

    public String getPhoneOfClient() {
        return phoneOfClient;
    }

    public void setPhoneOfClient(String phoneOfClient) {
        this.phoneOfClient = phoneOfClient;
    }

    public String getStartOfTheRout() {
        return startOfTheRout;
    }

    public void setStartOfTheRout(String startOfTheRout) {
        this.startOfTheRout = startOfTheRout;
    }

    public String getEndOfRoutLocation() {
        return endOfRoutLocation;
    }

    public void setEndOfRoutLocation(String endOfRoutLocation) {
        this.endOfRoutLocation = endOfRoutLocation;
    }

    public String getStartOfRoutLocation() {
        return startOfRoutLocation;
    }

    public void setStartOfRoutLocation(String startOfRoutLocation) {
        this.startOfRoutLocation = startOfRoutLocation;
    }

    public String getEndOfTheRout() {
        return endOfTheRout;
    }

    public void setEndOfTheRout(String endOfTheRout) {
        this.endOfTheRout = endOfTheRout;
    }
}
