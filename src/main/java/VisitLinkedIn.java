import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.lang.*;
import javax.swing.*;
public class VisitLinkedIn {

    public static void main(String[] args) throws InterruptedException {

    checkOutLinkedIn();
    }
    public static void checkOutLinkedIn() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kenji\\Documents\\PROGRAMMING\\ScrubbingLinkedIn\\chromedriver_win32\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        ArrayList<String> myJobs = new ArrayList<>(2);
        chromeDriver.get("https://www.linkedin.com");

        chromeDriver.findElement(By.cssSelector("#session_key")).sendKeys("fortestingonlyperiod@gmail.com");
        chromeDriver.findElement(By.cssSelector("#session_password")).sendKeys("testing123$");
        Thread.sleep(4000);
        chromeDriver.findElement(By.cssSelector("button[type='submit']")).click();
        chromeDriver.findElement(By.xpath("//span[@title ='Jobs']")).click();
        Thread.sleep(3000);
        String job1 = chromeDriver.findElement(By.xpath("//ul[@class = 'ph3']/li[1]")).getText();
        String job2 = chromeDriver.findElement(By.xpath("//ul[@class = 'ph3']/li[2]")).getText();
        myJobs.add(job1);
        myJobs.add(job2);

        int option = JOptionPane.showConfirmDialog(null, "Top 2 Jobs \n"+job1+"\n______________________\n"+job2+"/\n Do you want to learn more?");

        if(option == 0)
        {
            chromeDriver.findElement(By.xpath("//ul[@class = 'ph3']/li[1]")).click();
        }else if(option == 1)
        {
            chromeDriver.quit();
            chromeDriver.close();
        }else if(option == 2)
        {
            Thread.sleep(3000);
            chromeDriver.close();
            chromeDriver.quit();
        }
        System.out.println("Top 2 jobs this search");
        for(String job : myJobs)
        {
            System.out.println(job);
            System.out.println("-------------------------------");
        }

    }
}
