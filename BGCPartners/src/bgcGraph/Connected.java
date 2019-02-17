package bgcGraph;

import java.util.*;

import java.io.*;

public class Connected{

    public static final String fileName = "cities.txt";

    public static BufferedReader br = null;
    public static FileReader fr = null;
    public static HashSet<String> uniqueCities ;
    public static HashMap<String, String> edges;
    
    //this method helps to handle the text input file and extract the start and end city nodes to check for connectivity
    public static void readFile()
    {
        uniqueCities = new HashSet<String>();
        edges = new HashMap<String, String>();
        try {

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] lineinfo = sCurrentLine.split(","); //processing input file to split on commas between cities
                String startCity = lineinfo[0].trim();
                String endCity = lineinfo[1].trim();
                uniqueCities.add(startCity);
                uniqueCities.add(endCity);
                edges.put(startCity, endCity);
            }

        } catch (IOException e) {
            System.out.println("Could not read file"); //exception handling
        }

        finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                System.out.println("File IO is corrupted");
            }
        }
    }

    public static void main(String [] args)
	{
		 // Read file and get data
        readFile();
        ConnectedHelper graph = new ConnectedHelper(uniqueCities.stream().toArray(String[]::new));//creating Connected String[] object as per constructor defined in ConnectedHelper class
        Iterator it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            graph.addEdge((String) pair.getKey(), (String)pair.getValue());
        }
      //From command line, it takes in two cities and runs for connectivity returning either true or false.
      //Within Eclipse IDE, you can enter the two arguments by going to Eclipse, Run Configurations and enter the specified arguments like you would from Command Line as well
        System.out.println(graph.isConnected(args[0], args[1])); 
	}
	
}