package javaFinal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class GetRequest {
	
	
	public static void showPieChart(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(url))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());

	    String x=response.body();
	    ArrayList<String> y=new ArrayList<String>();
	    Scanner sc = new Scanner(x).useDelimiter(",");
	    while (sc.hasNext()) {
	    	y.add(sc.next());
	    }
	    List<String> a=new ArrayList<String>();
	    List<Integer> b=new ArrayList<Integer>();
	    for(int i=0;i<(y.size()/2)-4;i++) {
	    	a.add(y.get(i));
	    }
	    for(int i=1542;i<y.size();i++) {
	    	b.add(Integer.parseInt(y.get(i).substring(1,2)));
           
	    	
	    	
	    }
	   
	    PieChart chart =new PieChartBuilder().width(800).height(600).title("Try Xchart").build(); //create chart
		b.size();
		for(int i=0; i<b.size(); i++) {
		chart.addSeries(a.get(i), b.get(i));
		
		}
		new SwingWrapper(chart).displayChart();
	    
	    
	    
	    
	    
	   
	}
	
	
	public static void showBarChartJobs(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(url))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());

	    String x=response.body();
	    ArrayList<String> y=new ArrayList<String>();
	    Scanner sc = new Scanner(x).useDelimiter(",");
	    while (sc.hasNext()) {
	    	y.add(sc.next());
	    }
	    List<String> a=new ArrayList<String>();
	    List<Integer> b=new ArrayList<Integer>();
	    for(int i=0;i<2991;i++) {
	    	a.add(y.get(i));
	    }
	    for(int i=2992;i<y.size();i++) {
	    	b.add(Integer.parseInt(y.get(i).substring(1,2)));
           
	    	
	    	
	    }
	    //System.out.println(y.get(2992));
	   
	  CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Popular Job Titles").xAxisTitle("Job Titles").yAxisTitle("Count").build();
      b.size();

      chart.addSeries( "Most Popular Jobs", a.subList(0,5),b.subList(0,5));

      new SwingWrapper(chart).displayChart();
	    
	    
	    
	    
	    
	   
	}
	
	
	public static void showBarChartAreas(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(url))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());

	    String x=response.body();
	    ArrayList<String> y=new ArrayList<String>();
	    Scanner sc = new Scanner(x).useDelimiter(",");
	    while (sc.hasNext()) {
	    	y.add(sc.next());
	    }
	    List<String> a=new ArrayList<String>();
	    List<Integer> b=new ArrayList<Integer>();
	    for(int i=0;i<y.size()/2;i++) {
	    	a.add(y.get(i));
	    	//System.out.println(y.get(i));
	    }
	    for(int i=y.size()/2;i<y.size();i++) {
	    	b.add(Integer.parseInt(y.get(i).substring(1,2)));
	    	//System.out.println(y.get(i).substring(1,2));
	    	
	    	
	    }
	    System.out.println(y.size());
	    System.out.println(a.size());
	   
	  CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Popular Areas").xAxisTitle("Location").yAxisTitle("Count").build();
      b.size();

      chart.addSeries( "Most Popular Jobs", a.subList(0,5),b.subList(0,5));

      new SwingWrapper(chart).displayChart();
	    
	    
	    
	    
	    
	   
	}
	
	
	
	
	
	
	public static void showTable(String url) throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(url))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());

	    System.out.println(response.body());
	    
	}
	
	
	
	
	
	
	
	public static void main (String[]args) throws IOException, InterruptedException {
		//showTable("http://localhost:8090/showAllData");   //show all data
		//showTable("http://localhost:8090/cleanedData");    //show cleaned data
		//showTable("http://localhost:8090/mostDemanding");   //show most demanding companies
		//showPieChart("http://localhost:8090/companiesPieChart");//show pie chart for the previous step
		//showTable("http://localhost:8090/popularJobs");      //show most popular jobs
		//showBarChartJobs("http://localhost:8090/barChartJobs");       //show bar chart for the previous step
		//showTable("http://localhost:8090/popularAreas");     //show most popular area
		showBarChartAreas("http://localhost:8090/barChartAreas");   //show bar chart for the previous step
		//showTable("http://localhost:8090/popularSkills");     //show most popular skills
		
		
	}
}
