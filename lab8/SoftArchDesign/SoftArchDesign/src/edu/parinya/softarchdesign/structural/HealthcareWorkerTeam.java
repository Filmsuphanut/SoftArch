package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{

    private Set<HealthcareServiceable> members;

    public HealthcareWorkerTeam() {
        members = new LinkedHashSet<>();
    }

    @Override
    public void service() {
        for (HealthcareServiceable m : members) {
            m.service();
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (HealthcareServiceable m : members) {
            price += m.getPrice();
        }
        return price;
    }


    public void addMember(HealthcareServiceable worker) {
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker) {
        members.remove(worker);
    }
}
