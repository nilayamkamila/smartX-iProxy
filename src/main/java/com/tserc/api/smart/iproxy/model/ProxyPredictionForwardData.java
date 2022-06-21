package com.tserc.api.smart.iproxy.model;

/*
{
    "experience": "5.5",
    "forwardTo": "1.5049786360984057",
    "salary": "77152.56728844717"
}
 */
public class ProxyPredictionForwardData {
    private String experience;
    private String forwardTo;
    private String salary;

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getForwardTo() {
        return forwardTo;
    }

    public void setForwardTo(String forwardTo) {
        this.forwardTo = forwardTo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
