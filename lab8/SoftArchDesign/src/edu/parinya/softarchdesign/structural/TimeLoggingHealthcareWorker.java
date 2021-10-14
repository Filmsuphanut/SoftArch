package edu.parinya.softarchdesign.structural;

import java.sql.Timestamp;
import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {
    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TimeLogging.");
    }

    @Override
    public void service() {
        Timestamp ts= new Timestamp(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        System.out.print(date + ": ");
        super.service();
    }

}
