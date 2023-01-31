package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.base.ReusableMethods;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends ReusableMethods {
	public static void generateJVMReport(String jsonfile) {
		File file1 = new File(getProjectLoc()+"\\target");
		
		Configuration config = new Configuration(file1,"Adactin Automation");
		config.addClassifications("OS","WIN10");
		config.addClassifications("Browser","Chrome");
		config.addClassifications("Browser Version","104");
		config.addClassifications("Sprint","35");
		List<String> jsonfiles = new ArrayList<String>();
		jsonfiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonfiles,config);
		builder.generateReports();
}
}
