
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class SystemMonitor {

    public static void main(String[] args) throws Exception {

        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        while (true) {

            double cpuLoad = osBean.getProcessCpuLoad() * 100;

            long totalMemory = osBean.getCommittedVirtualMemorySize();
            long freeMemory = osBean.getFreePhysicalMemorySize();
            long usedMemory = totalMemory - freeMemory;

            System.out.println("CPU Usage: " + String.format("%.2f", cpuLoad) + "%");
            System.out.println("Used RAM: " + (usedMemory / 1024 / 1024) + " MB");
            System.out.println("Free RAM: " + (freeMemory / 1024 / 1024) + " MB");
            System.out.println("--------------------------");

            Thread.sleep(1000);

            if (Thread.interrupted()) // Clears interrupted status!
                throw new InterruptedException();

        }
    }
}
