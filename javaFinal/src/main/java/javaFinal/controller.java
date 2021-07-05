
package javaFinal;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.knowm.xchart.PieChart;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joinery.DataFrame;
import tech.tablesaw.api.Table;

@RestController
public class controller {
	StructuredData jobs=new StructuredData("D:\\ITI AI-pro\\java uml programming\\Wuzzuf_Jobs.csv");
    
      @RequestMapping("/showAllData")
    public String allData() throws IOException{
    	  return Methods.allData(jobs.tableSaw()).toString();}
      @RequestMapping("/cleanedData")
      public String cleanData() throws IOException{
      	  return Methods.cleanData(jobs.tableSaw()).toString();}
      

      @RequestMapping("/mostDemanding")
    public String mostDemanding() throws IOException{
    	  return Methods.mostDemanding(jobs.joinery()).toString();}
      
     @RequestMapping("/companiesPieChart")
     public List<String> xChartJobs() throws IOException{
   	  return Methods.xChartJobs(jobs.joinery());}

      @RequestMapping("/popularJobs")
      public String popularJobs() throws IOException{
        	  return Methods.popularJobs(jobs.joinery()).toString();}
    
      @RequestMapping("/barChartJobs")
      public List<String> barChartJobs() throws IOException{
       	  return Methods.barChartJobs(jobs.joinery());}
      
      @RequestMapping("/popularAreas")
      public String popularAreas() throws IOException{
        	  return Methods.popularAreas(jobs.joinery()).toString();}
      
      @RequestMapping("/barChartAreas")
      public List<String> barChartAreas() throws IOException{
       	  return Methods.barChartAreas(jobs.joinery());}      
      @RequestMapping("/popularSkills")
      public String popularSkills() throws IOException{
        	  return Methods.popularSkills(jobs.tableSaw()).toString();}
      
      
}
