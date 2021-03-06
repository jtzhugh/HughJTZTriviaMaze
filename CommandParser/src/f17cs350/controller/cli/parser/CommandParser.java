package f17cs350.controller.cli.parser;

import f17cs350.*;
import f17cs350.controller.command.A_Command;
import f17cs350.controller.command.meta.CommandMetaDoExit;
//Testing testing testing
//RULES NOT HANDLED YET: 1 AND 67
public class CommandParser {
	
	private String commandText = "";// this will always hold the whole command unparsed;
	private String[] parts; //this holds the single word parsed from the command at parts[0]. The rest of the
							//string is at parts[1]
	private String currentString = "";// this will hold the part of the command that hasn't yet been parsed
	private Object parserHelper;
	
	public CommandParser(MyParserHelper parserHelper, String commandText) {
		this.commandText = commandText;
		this.parserHelper = parserHelper;
	}

	public void parse() {
		char first = commandText.charAt(0);
		if(first == '@') {
			parseAtCommand();
		}
		else {
			parts = commandText.split(" ");
			currentString = parts[1];
			String command = parts[0]; //Valid words: DO, CREATE, USE, COUPLE, COMMIT, LOCATE, CLOSE
													// OPEN, SYNC, UNSYNC, MAP, UNCOUPLE, USE
			if(parts[0].equalsIgnoreCase("create"))
				parseCreate();
			else if(parts[0].equalsIgnoreCase("do"))
				parseDo();
			else 
				parseOther(command); // this method throws error if string command is not one of the valid words ^^^
				
				
		}
	}
	
	private boolean checkValidFirstWord(String string) {
		//if command is a valid word, return true;
		//Valid words: USE, COUPLE, COMMIT, LOCATE, CLOSE
		//OPEN, SYNC, UNSYNC, MAP, UNCOUPLE
		//disregard "DO" and "CREATE" since method parse() took care of it
		if (string.equalsIgnoreCase("couple")      ||
				string.equalsIgnoreCase("uncouple")||
				string.equalsIgnoreCase("commit")  ||
				string.equalsIgnoreCase("locate")  ||
				string.equalsIgnoreCase("close")   ||
				string.equalsIgnoreCase("open")    ||
				string.equalsIgnoreCase("map"))
			return true;
		
		return false;
		
	}
	//parse all commands starting with '@'
	private void parseAtCommand(){
		if(commandText.equalsIgnoreCase("@exit")) {
			A_Command command = new CommandMetaDoExit();
			((A_ParserHelper) this.parserHelper).getActionProcessor().schedule(command);
		}
		else if(commandText.equalsIgnoreCase("@run")) {
			//FINISH THIS 52
		}
		else if(commandText.equalsIgnoreCase("@schedule")) {
			//FINISH THIS 53
		}
	}
	
	//parse all commands starting with 'CREATE'
	private void parseCreate() {
		parts = commandText.split(" ");
		currentString = parts[1];
		String command = parts[0];
		if(command.equalsIgnoreCase("power")) {
			parseCreatePower();
		}
		if(command.equalsIgnoreCase("stock")) {
			parseCreateStock();
		}
		if(command.equalsIgnoreCase("track")) {
			parseCreateTrack();
		}
		
	}
	
	private void parseCreatePower() {
		parts = currentString.split(" ");
		currentString = parts[1];
		String command = parts[0];
		if(command.equalsIgnoreCase("catenary")) {
			//FINISH THIS 22
		}
		if(command.equalsIgnoreCase("pole")) {
			//FINISH THIS 23
		}
		if(command.equalsIgnoreCase("station")) {
			//FINISH THIS 24
		}
		if(command.equalsIgnoreCase("substation")) {
			//FINISH THIS 25
			//Need to figure out a way to find by ID
			
			String[] currentIdSplit = currentString.split(" ");
			String id = currentIdSplit[0];
			String newS = currentIdSplit.split(" ");
			if(newS[0])
			CommandCreatePowerSubstation()
		}
	}
	private void parseCreateStock() {
		parts = currentString.split(" ");
		currentString = parts[1];
		String command = parts[0];
		String id;
		if(command.equalsIgnoreCase("car")) {
			parts = currentString.split(" "); //reads in id for car
			currentString = parts[1];
			id = parts[0];
			if (currentString.equalsIgnoreCase("as box")) {
				//CREATE A BOX CAR WITH ID id HERE
			}
			else if (currentString.equalsIgnoreCase("as caboose")) {
				//CREATE A CABOOSE CAR WITH ID id HERE
			}
			else if (currentString.equalsIgnoreCase("as flatbed")) {
				//CREATE A FLATBED CAR WITH ID id HERE
				CommandCreateStockCarFlatbed(id);
			}
			else if (currentString.equalsIgnoreCase("as passenger")) {
				//CREATE A PASSENGER CAR WITH ID id HERE
				CommandCreateStockCarPassenger(id);
			}
			else if (currentString.equalsIgnoreCase("as tank")) {
				//CREATE A TANK CAR WITH ID id HERE
				CommandCreateStockCarTank(id);
			}
			else if (currentString.equalsIgnoreCase("as tender")) {
				//CREATE A TENDER CAR WITH ID id HERE
			}
			else {
				//user is trying to make an invalid car. handle this...
				throw new RuntimeException("Not a valid Stock Car Command");
			}
		}
		else if(command.equalsIgnoreCase("engine")) {
			//FINISH THIS 34
		}
		else {
			//user is trying to create something invalid, handle this
			throw new RuntimeException("Not a valid stock creation command");
		}
		
	}
	private void parseCreateTrack() {
		parts = currentString.split(" ");
		currentString = parts[1];
		String command = parts[0];
		String id;
		
		if (command.equalsIgnoreCase("bridge")) {
			parts = currentString.split(" ");
			currentString = parts[1];
			command = parts[0];
			if (command.equalsIgnoreCase("draw")) {
				//FINISH THIS 39
			}
			else {
				id = command;
				//FINISH THIS 40
			}
		}
		else if(command.equalsIgnoreCase("crossing")) {
			//FINISH THIS 41
		}
		else if(command.equalsIgnoreCase("crossover")) {
			//FINISH THIS 42
		}
		else if(command.equalsIgnoreCase("curve")) {
			//FINISH THIS 43
		}
		else if(command.equalsIgnoreCase("end")) {
			//FINISH THIS 44
		}
		else if(command.equalsIgnoreCase("layout")) {
			//FINISH THIS 45
		}
		else if(command.equalsIgnoreCase("roundhouse")) {
			//FINISH THIS 46
		}
		else if(command.equalsIgnoreCase("straight")) {
			//FINISH THIS 47
		}
		else if(command.equalsIgnoreCase("switch")) {
			//FINISH THIS 48 && 49
			parts = currentString.split(" ");
			currentString = parts[1];
			command = parts[0];
			if(command.equalsIgnoreCase("turnout")) {
				
			}
			else if(command.equalsIgnoreCase("wye")) {
				
			}
			else {
				//invalid track switch
				throw new RuntimeException("invalde track switch");
			}
				
			
		}
		else {
			//invalid track create
			throw new RuntimeException("invalde track create command");
		}
	}
	
	//parse all commands starting with 'DO'
	private void parseDo() {
		parts = commandText.split(" ");
		currentString = parts[1];
		String command = parts[0];
		if(command.equalsIgnoreCase("brake")) {
			parseDoBrake();
		}
		else if(command.equalsIgnoreCase("select")) {
			parseDoSelect();
		}
		else if(command.equalsIgnoreCase("set")) {
			parseDoSet();
		}
		else {
			//trying to do something invalid
			throw new RuntimeException();
		}
		
	}
	
	private void parseDoBrake() {
		//FINISH THIS 2
	}
	
	private void parseDoSelect() {
		parts = currentString.split(" ");
		currentString = parts[1];
		String command = parts[0];
		
		if(command.equalsIgnoreCase("drawbridge")) {
			//FINISH THIS 6
		}
		else if(command.equalsIgnoreCase("roundhouse")) {
			//FINISH THIS 7
		}
		else if(command.equalsIgnoreCase("switch")) {
			//FINISH THIS 8
		}
		else {
			//trying to select something invalid
			throw new RuntimeException();
		}
	}
	private void parseDoSet() {
		parts = currentString.split(" ");
		currentString = parts[1];
		String command = parts[0];
		String id;
		if(command.equalsIgnoreCase("reference")) {
			//FINISH THIS 12
		}
		else {
			id = command;
			parts = currentString.split(" ");
			currentString = parts[1];
			command = parts[0];
			if(command.equalsIgnoreCase("direction")) {
				//FINISH THIS 11
			}
			else if(command.equalsIgnoreCase("speed")) {
				//FINISH THIS 15
			}
			
		}
	}
	
	//this method parses any command that doesn't start with '@' 'DO' or 'CREATE'
	//By calling checkValidWord(), if command doesn't start with proper syntax, throw an exception.
	private void parseOther(String command) {
		if(!checkValidFirstWord(command))
			throw new RuntimeException();
		
		parts = currentString.split(" ");
		currentString = parts[1];
		command = parts[0];
		if(command.equalsIgnoreCase("commit")) {
			//FINISH THIS 60
		}
		else if(command.equalsIgnoreCase("couple")) {
			//FINISH THIS 61
		}
		else if(command.equalsIgnoreCase("locate")) {
			//FINISH THIS 62
		}
		else if(command.equalsIgnoreCase("uncouple")) {
			//FINISH THIS 65
		}
		else if(command.equalsIgnoreCase("use")) {
			//FINISH THIS 66
		}
		else {
			//invalid command
			throw new RuntimeException("invalid command");
		}
			
	}//end parseOther
	
		public static void main(String[] args)
	{
		Startup startup = new Startup();
		
		startup.go();
	}//end main
	
	
	
}// end class
