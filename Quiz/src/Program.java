import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Program {
    private final LinkedList<Patient> patients;
    private final Map<Patient, Database> patientDataHistory;
    private final NurseStation nurseStation;

    public Program() {
        patients = new LinkedList<>();
        patientDataHistory = new HashMap<>();
        nurseStation = new NurseStation();
    }

    public void addPatient(Patient newPatient) throws Exception {

        for (var p : patients) {
            if (Objects.equals(p.getName(), newPatient.getName())) {
                throw new Exception("Can't have patient with same name.");
            }
        }

        patients.add(newPatient);
        patientDataHistory.put(newPatient, new Database());
    }

    public void StartSystem(int period) {
        for (int t = 0; t <= period; t++) {
            for (var p: patients) {
                if (!p.isMonitorTime(t)) continue;

                var data = p.ReadSensor();

                for (var d : data) {
                    patientDataHistory.get(p).Store(d.getSensorName(), new Factor(t, d.getSensorData()));

                    if (d.getStatus() == StatusCode.Normal) continue;

                    showErrorMessage(t, p.getName(), d);
                }
            }
        }

        for (var p : patients) {
            System.out.println("patient " + p.getName());

            var history = patientDataHistory.get(p);
            for (var info : p.getSensorInfos()) {
                System.out.println(info.getType() + " " + info.getName());

                var sensorDataList = history.getHistory(info.getName());

                for (var data : sensorDataList) {
                    System.out.println("[" + data.getTimeStamp() + "] " + String.format("%1$,.1f", data.getData()));
                }
            }
        }
    }

    private void showErrorMessage(int timeStamp, String patientName, MonitorResult result) {
        if (result.getStatus() == StatusCode.SensorFail) {
            nurseStation.ShowAlarm("[" + timeStamp + "] " + result.getSensorName() + " fails");
        } else if (result.getStatus() == StatusCode.Danger) {
            nurseStation.ShowAlarm("[" + timeStamp + "] " + patientName + " is in danger! Cause: " + result.getSensorName() + " " + String.format("%1$,.1f", result.getSensorData()));
        }
    }
}
