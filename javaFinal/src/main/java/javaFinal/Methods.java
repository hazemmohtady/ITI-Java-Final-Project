package javaFinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import joinery.DataFrame;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class Methods {
	public static Table allData(Table jobs) throws IOException{
		return jobs;
	}
	public static Table cleanData(Table jobs) throws IOException{
		jobs=jobs.dropDuplicateRows().dropRowsWithMissingValues();
		return jobs;
	}
	public static DataFrame<?> mostDemanding(DataFrame<?> jobs) throws IOException{
		DataFrame<?> jobsNo=jobs.groupBy("Company").count();
		jobsNo=jobsNo.retain("Company","Title").sortBy("-Title").head(20);
		return jobsNo;
	}
	
	
	public static List<String> xChartJobs(DataFrame<?> jobs) throws IOException{
		DataFrame<?> jobsNo=jobs.groupBy("Company").count();
		List<String> companies=(List<String>) jobsNo.col("Company");
		List<Integer> jobCount=(List<Integer>) jobsNo.col("Title");
		List<String> chartContent=new ArrayList<String>();
		for(int i=0;i<jobCount.size();i++) {
			chartContent.add(companies.get(i));
		}
		for(int i=0;i<jobCount.size();i++) {
			chartContent.add(jobCount.get(i).toString());
		}
		
		return chartContent;
	}
	
	
	public static DataFrame<?> popularJobs(DataFrame<?> jobTitles) throws IOException {
        DataFrame<?> jobTitlesCount = jobTitles.groupBy("Title").count();
        jobTitlesCount = jobTitlesCount.retain("Title","Company").sortBy("-Company");
        return jobTitlesCount;
    }
	public static List<String> barChartJobs(DataFrame<?> jobTitles) throws IOException {
        DataFrame<?> jobTitlesCount = jobTitles.groupBy("Title").count();
        jobTitlesCount = jobTitlesCount.retain("Title", "Company").sortBy("-Company");
        List<String> jobTitle = (List<String>) jobTitlesCount.col("Title");
        List<Integer> jobTitleCount = (List<Integer>) jobTitlesCount.col("Company");

        List<String> chartContent=new ArrayList<String>();
		for(int i=0;i<jobTitleCount.size();i++) {
			chartContent.add(jobTitle.get(i));
		}
		for(int i=0;i<jobTitleCount.size();i++) {
			chartContent.add(jobTitleCount.get(i).toString());
		}
		
		return chartContent;
        
    }
	public static DataFrame<?> popularAreas(DataFrame<?> areas) throws IOException {
        DataFrame<?> areasCount = areas.groupBy("Location").count();
        areasCount = areasCount.retain("Location", "Country").sortBy("-Country");
        return areasCount;
    }
	public static List<String> barChartAreas(DataFrame<?> areas) throws IOException {
	        DataFrame<?> areasCount = areas.groupBy("Location").count();
	        areasCount = areasCount.retain("Location", "Country").sortBy("-Country");
	        List<String> location = (List<String>) areasCount.col("Location");
	        List<Integer> locationCount = (List<Integer>) areasCount.col("Country");
	        List<String> chartContent=new ArrayList<String>();
			for(int i=0;i<locationCount.size();i++) {
				chartContent.add(location.get(i));
			}
			for(int i=0;i<locationCount.size();i++) {
				chartContent.add(locationCount.get(i).toString());
			}
			
			return chartContent;
	    }
	public static Table  popularSkills(Table Wuzzaf2) throws IOException{
   		   StringColumn col2 = Wuzzaf2.stringColumn("Skills");
           List<String> lst2=col2.asList();
           final Map<String,Integer> skills1=new HashMap<String,Integer>();
           for(int ii=0;ii<lst2.size();ii++){
               Arrays.stream((lst2.get(ii)).split(",")).forEach(a->{
                   if(skills1.containsKey(a)){
                       skills1.put(a,skills1.get(a)+1);
                   }
                   else{
                       skills1.put(a,1);
                   }
               });

           }
           Map<String,Integer> Skills=sortByValue(skills1,false);
           Table table =
                   Table.create("Skills")
                           .addColumns(
                                   StringColumn.create("Skills", Skills.keySet()),
                                   DoubleColumn.create("Count", Skills.values()));
           return table;

       }
		
	//Helper Method
	private static Map<String, Integer> sortByValue(Map<String, Integer> map,boolean order)
    {
//convert HashMap into List
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
//sorting the list elements
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                if (order)
                {
//compare two object and return an integer
                    return o1.getValue().compareTo(o2.getValue());}
                else
                {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
//prints the sorted HashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        //System.out.println(sortedMap);
        return sortedMap;
    }	


}
