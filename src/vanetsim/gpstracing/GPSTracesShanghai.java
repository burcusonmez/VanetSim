package vanetsim.gpstracing;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import vanetsim.map.Map;
//TODO:uploaded
public class GPSTracesShanghai {

	/** The path of the TXT file*/
	private String txtPath_;
	
	/** The default path and filename, used if no path is set*/
	private String defaultPath_ = "/VanetSim/GPX_Data/Shanghai_Traces/Shanghai_Taxi_traces.txt";
	
	/** The ArrayList types collects all GPSDATA*/
	public ArrayList<String> shTraces_;
	
	/** If no path is set, the default path is used
	 * @return */
	public void Shanghai_Traces_CSV(String path){
		txtPath_ = defaultPath_;
		//if(path == null) txtPath_ = defaultPath_;
		//else txtPath_ = path;		
	}
	/** The only instance of this class (singleton). */
	private static final GPSTracesShanghai INSTANCE = new GPSTracesShanghai();
	
	
	public static GPSTracesShanghai getInstance(){
		return INSTANCE;
	}
	
	public ArrayList<String> getShanghaiTraces(){
		 shTraces_ = new ArrayList<String>();
		 
		 File ShanghaiFile_ = new File("../VanetSim/GPX_Data/Shanghai_Traces/Shanghai_Taxi_traces.txt");
		 BufferedReader br = null;
	        String sCurrentLine = null;
	        try
	        {
	          br = new BufferedReader(
	          new FileReader(ShanghaiFile_));
	            while ((sCurrentLine = br.readLine()) != null)
	            {
	            	//Parse here 
	            	String[] columns = sCurrentLine.split(",");
	            	
	            	//String ID = columns[0];  
                    String TaxiID = columns[1];  
                    String Lon = columns[2];
                    String Lat = columns[3];  
                    //String Speed = columns[4];  
                    //String Angle = columns[5]; 
                    String Time = columns[6];  
                    //String Status = columns[7];  
                    //String EStatus = columns[8];  
                    //String Reversed = columns[9];  
                    
                    System.out.println("TaxiID " + TaxiID);
                    System.out.println("Lon " + Lon);
                    System.out.println("Lat " + Lat);
                    System.out.println("Time " + Time);
                    
                    
                   //Add to Array List 
                    
                    shTraces_.add(TaxiID);
                    shTraces_.add(Lon);
                    shTraces_.add(Lat);
                    shTraces_.add(Time);
   
	                //System.out.println(sCurrentLine);
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                if (br != null)
	                br.close();
	            } catch (IOException ex)
	            {
	                ex.printStackTrace();
	            }
	        }	 
		 //Return Array List
		 return shTraces_;
	}
	
}