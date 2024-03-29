package com.business.businessapp.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.business.businessapp.repositories.AccountRepository;
import com.business.businessapp.repositories.AccountantRepository;
import com.business.businessapp.repositories.CompanyRepository;
import com.business.businessapp.repositories.ManagerRepository;
import com.business.businessapp.repositories.TransactionRepository;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DBInitializer implements CommandLineRunner {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountantRepository accountantRepository;
	
	@Autowired
	private ManagerRepository managerRepository;
	
	
	private static final Random random = new Random(1);
	 
	private static final String[] IBANS = new String[] {
            "AD12 0001 2030 2003 5910 0100", "AE07 0331 2345 6789 0123 456",
            "AL47 2121 1009 0000 0002 3569 8741", "AT61 1904 3002 3457 3201",
            "AZ21 NABZ 0000 0000 1370 1000 1944", "BA39 1290 0794 0102 8494",
            "BE68 5390 0754 7034", "BG80 BNBG 9661 1020 3456 78",
            "BH67 BMAG 0000 1299 1234 56",
            "BR18 0036 0305 0000 1000 9795 493C 1",
            "BY13 NBRB 3600 9000 0000 2Z00 AB00", "CH93 0076 2011 6238 5295 7",
            "CR05 0152 0200 1026 2840 66", "CY17 0020 0128 0000 0012 0052 7600",
            "CZ65 0800 0000 1920 0014 5399", "DE89 3704 0044 0532 0130 00",
            "DK50 0040 0440 1162 43", "DO28 BAGR 0000 0001 2124 5361 1324",
            "EE38 2200 2210 2014 5685", "ES91 2100 0418 4502 0005 1332",
            "FI21 1234 5600 0007 85", "FO62 6460 0001 6316 34",
            "FR14 2004 1010 0505 0001 3M02 606", "GB29 NWBK 6016 1331 9268 19",
            "GE29 NB00 0000 0101 9049 17", "GI75 NWBK 0000 0000 7099 453",
            "GL89 6471 0001 0002 06", "GR16 0110 1250 0000 0001 2300 695",
            "GT82 TRAJ 0102 0000 0012 1002 9690", "HR12 1001 0051 8630 0016 0",
            "HU42 1177 3016 1111 1018 0000 0000", "IE29 AIBK 9311 5212 3456 78",
            "IL62 0108 0000 0009 9999 999", "IQ98 NBIQ 8501 2345 6789 012",
            "IS14 0159 2600 7654 5510 7303 39",
            "IT60 X054 2811 1010 0000 0123 456",
            "JO94 CBJO 0010 0000 0000 0131 0003 02",
            "KW81 CBKU 0000 0000 0000 1234 5601 01", "KZ86 125K ZT50 0410 0100",
            "LB62 0999 0000 0001 0019 0122 9114",
            "LC55 HEMM 0001 0001 0012 0012 0002 3015",
            "LI21 0881 0000 2324 013A A", "LT12 1000 0111 0100 1000",
            "LU28 0019 4006 4475 0000", "LV80 BANK 0000 4351 9500 1",
            "MC58 1122 2000 0101 2345 6789 030",
            "MD24 AG00 0225 1000 1310 4168", "ME25 5050 0001 2345 6789 51",
            "MK07 2501 2000 0058 984", "MR13 0002 0001 0100 0012 3456 753",
            "MT84 MALT 0110 0001 2345 MTLC AST0 01S",
            "MU17 BOMM 0101 1010 3030 0200 000M UR", "NL91 ABNA 0417 1643 00",
            "NO93 8601 1117 947", "PK36 SCBL 0000 0011 2345 6702",
            "PL61 1090 1014 0000 0712 1981 2874",
            "PS92 PALS 0000 0000 0400 1234 5670 2",
            "PT50 0002 0123 1234 5678 9015 4",
            "QA58 DOHB 0000 1234 5678 90AB CDEF G",
            "RO49 AAAA 1B31 0075 9384 0000", "RS35 2600 0560 1001 6113 79",
            "SA03 8000 0000 6080 1016 7519",
            "SC18 SSCB 1101 0000 0000 0000 1497 USD",
            "SE45 5000 0000 0583 9825 7466", "SI56 2633 0001 2039 086",
            "SK31 1200 0000 1987 4263 7541",
            "SM86 U032 2509 8000 0000 0270 100",
            "ST68 0002 0001 0192 1942 1011 2",
            "SV62 CENR 0000 0000 0000 0070 0025",
            "TL38 0080 0123 4567 8910 157", "TN59 1000 6035 1835 9847 8831",
            "TR33 0006 1005 1978 6457 8413 26",
            "UA21 3996 2200 0002 6007 2335 6600 1",
            "VG96 VPVG 0000 0123 4567 8901", "XK05 1212 0123 4567 8906",
            "YY24 KIHB 1247 6423 1259 1594 7930 9152 68",
            "ZZ25 VLQT 3823 3223 3206 5880 1131 3776 421" };
    
	private static final String[] COMPANIES = new String[] {
            "Brewer Holding Century Training", "Broadcast Electric",
            "Chemical General Development", "Digital Agricultural Dynamics",
            "Demondu Semiconductors", "Cota Realisations",
            "European Photographic", "Financial Supplies",
            "Genetics Leasing Mechanical", "Henderson Publishing",
            "Innovative Cyberbank", "Prosaria Equipment Networks", "Kilobank",
            "McCray Mechanical Manufacturing", "Medical Telecommunications",
            "Navarro Horizon Gold Products", "Network Office Contractors",
            "Sharp Network Sciences", "Speciality Investments",
            "Tanner Progressive Healthcare", "Terrell Royal Vistas",
            "Esill Integration", "Aeon Transportation Atomic",
            "Fambu Development", "Atomic Broadcasting", "Boyer Scientific",
            "Buck Motors", "Canadian Speciality Group",
            "Cargo Leasing Instructional", "Clark Industrial Semiconductors",
            "Engineered Open Sports", "European Chemical",
            "Fletcher Applied Aeon Power", "Fulton Memory Brokerage",
            "Lang Engineering", "Logistics Globosoft", "Medical Equipment",
            "Office Tele-Dynamics", "Skagen Unlimited", "Sawyer Technics",
            "Sharpe Genetics", "Comend Inc", "Strong Wholesale Manufacturing",
            "Diadoo Training", "Villarreal Industrial", "Wade Frontiers",
            "Wilcox Group", "Cement Precast Products", "Vicejo",
            "Microdel Service", "Skanti International", "Surous Plastics",
            "Genteel Graphics", "Conner Hearing Aid Clinic",
            "Nora Brennan Casting", "Cumbre", "Grafika", "Time Index",
            "Twiveo Printing & Mailing", "Peix & Marchetti Architects",
            "Quiyo Products", "Hermell Products", "Porter Chemical",
            "Chevron Asphalt Plant", "Texas Petrochemical",
            "Ladoo Finishing Equipment", "Paradeo Financial", "Semimm",
            "Redeo Continential", "Merten Co", "Hydronix Packaging",
            "Lafayette Printing", "Kanti Enterprise", "Frank Tava", "Promark",
            "Artisan Woods", "Divalane Summer", "Roodel Color Graphics",
            "Color Graphx", "Fastrax Enterprise", "Classic Markets Corp",
            "Builders & Homeowners Supply", "Prosaria Print Shop",
            "Conill Performance", "Camicee Coatings", "Protocero Networks",
            "Go Dynamics", "General Plastex", "Garible Durable",
            "Antelium Life Sciences" };
    
    private static final String[] BANKS = new String[] { "Aegis Bank",
            "Kindred Credit Union", "Oculus Bank System", "Aspire Credit Union",
            "Meridian Bancorp", "Focus Trust", "Cloud Nine Financial Corp.",
            "Lifespark Banks", "Obelisk Corporation", "Principal Banks" };
    
    private static final String[] FIRST_NAMES = new String[] { "James", "Mary",
            "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda",
            "William", "Elizabeth", "David", "Barbara", "Richard", "Susan",
            "Joseph", "Jessica", "Thomas", "Sarah", "Charles", "Margaret",
            "Christopher", "Karen", "Daniel", "Nancy", "Matthew", "Lisa",
            "Anthony", "Betty", "Donald", "Dorothy", "Mark", "Sandra", "Paul",
            "Ashley", "Steven", "Kimberly", "Andrew", "Donna", "Kenneth",
            "Emily", "George", "Carol", "Joshua", "Michelle", "Kevin", "Amanda",
            "Brian", "Melissa", "Edward", "Deborah", "Ronald", "Stephanie",
            "Timothy", "Rebecca", "Jason", "Laura", "Jeffrey", "Helen", "Ryan",
            "Sharon", "Jacob", "Cynthia", "Gary", "Kathleen", "Nicholas", "Amy",
            "Eric", "Shirley", "Stephen", "Angela", "Jonathan", "Anna", "Larry",
            "Ruth", "Justin", "Brenda", "Scott", "Pamela", "Brandon", "Nicole",
            "Frank", "Katherine", "Benjamin", "Samantha", "Gregory",
            "Christine", "Raymond", "Catherine", "Samuel", "Virginia",
            "Patrick", "Debra", "Alexander", "Rachel", "Jack", "Janet",
            "Dennis", "Emma", "Jerry", "Carolyn", "Tyler", "Maria", "Aaron",
            "Heather", "Henry", "Diane", "Jose", "Julie", "Douglas", "Joyce",
            "Peter", "Evelyn", "Adam", "Joan", "Nathan", "Victoria", "Zachary",
            "Kelly", "Walter", "Christina", "Kyle", "Lauren", "Harold",
            "Frances", "Carl", "Martha", "Jeremy", "Judith", "Gerald", "Cheryl",
            "Keith", "Megan", "Roger", "Andrea", "Arthur", "Olivia", "Terry",
            "Ann", "Lawrence", "Jean", "Sean", "Alice", "Christian",
            "Jacqueline", "Ethan", "Hannah", "Austin", "Doris", "Joe",
            "Kathryn", "Albert", "Gloria", "Jesse", "Teresa", "Willie", "Sara",
            "Billy", "Janice", "Bryan", "Marie", "Bruce", "Julia", "Noah",
            "Grace", "Jordan", "Judy", "Dylan", "Theresa", "Ralph", "Madison",
            "Roy", "Beverly", "Alan", "Denise", "Wayne", "Marilyn", "Eugene",
            "Amber", "Juan", "Danielle", "Gabriel", "Rose", "Louis", "Brittany",
            "Russell", "Diana", "Randy", "Abigail", "Vincent", "Natalie",
            "Philip", "Jane", "Logan", "Lori", "Bobby", "Alexis", "Harry",
            "Tiffany", "Johnny", "Kayla" };
    
    private static final String[] LAST_NAMES = new String[] { "Smith",
            "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller",
            "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson",
            "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez",
            "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
            "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill",
            "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter",
            "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell",
            "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez",
            "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy",
            "Bailey", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward",
            "Torres", "Peterson", "Gray", "Ramirez", "James", "Watson",
            "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes",
            "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell",
            "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler",
            "Simmons", "Foster", "Gonzales", "Bryant ", "Alexander", "Russell",
            "Griffin ", "Diaz", "Hayes" };

    
	@Override
	public void run(String... args) throws Exception {
		createCompanies();
		createAccounts();
		createTransactions();
		createAccountants();
		createManagers();
	}
	
	private void createCompanies() {
		List<Company> companies = new ArrayList<>();
		for(String companyName: COMPANIES) {
			companies.add(new Company(companyName));
		}
		companyRepository.saveAll(companies);
	}
	
	private void createAccounts() {
		List<Account> accounts = new ArrayList<>();
		for(String iban: IBANS ) {
			accounts.add(new Account(iban, getPositiveAmount(), getBank(), getCompany(), getDate()));
		}
		accountRepository.saveAll(accounts);
	}
	
	private void createTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(int i = 0; i < 40 ; i++) {
			Account[] accounts = getTwoDifferentAccounts();
			transactions.add(new Transaction(getPositiveAmount(), getDate(), getTransactionStatus(), accounts[0], accounts[1]));
		}
		transactionRepository.saveAll(transactions);
	}
	
	private void createAccountants() {
		List<Accountant> accountants = new ArrayList<Accountant>();
		for(int i = 0; i < 30 ; i++) {
			String firstName = getFirstName();
			String lastName = getLastName();
			String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@email.com";
			accountants.add(new Accountant(firstName, lastName, random.nextBoolean(), email, 
					getPhoneNumber(), getCompany(), getDate(), getRandomInt(0, 10), getRandomInt(0, 20)));
		}
		
		accountantRepository.saveAll(accountants);
	}
	
	private void createManagers() {
		List<Manager> managers = new ArrayList<Manager>();
		for(int i = 0; i < 30 ; i++) {
			String firstName = getFirstName();
			String lastName = getLastName();
			String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@email.com";
			managers.add(new Manager(firstName, lastName, random.nextBoolean(), email, 
					getPhoneNumber(), getCompany(), getDate(), getRandomDouble(0, 100000)));
		}
		
		managerRepository.saveAll(managers);
	}
	
	/// Utils to get Random Data
	
	// round double with 2 digits
	// we can use instead DecimalFormat(#.00)
	private double round(double value) {
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	private Double getAmount() {
		return random.nextBoolean() ? getPositiveAmount() : getNegativeAmount();
	}
	
	private Double getNegativeAmount() {
		return round(random.nextDouble() * -30000);
	}
	private Double getPositiveAmount() {
		return round(random.nextDouble() * 30000);
	}
	
	private String getBank() {
		return BANKS[random.nextInt(BANKS.length)];
	}
	
	private Company getCompany() {
		List<Company> companies = companyRepository.findAll();
		return companies.get(random.nextInt(companies.size()));
	}
	
	private LocalDate getDate() {
		return LocalDate.now().minusDays(random.nextInt(30));
	}
	
	private int getRandomInt(int min, int max) {
	    return random.nextInt(max + 1 - min) + min;
	}
   
	private Double getRandomDouble(int min, int max) {
		return min + (max - min) * random.nextDouble();  
	}

	private String getPhoneNumber() {
	    return String.format("%09d", random.nextInt(1000000000));
	}
	
	private String getFirstName() {
		return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
	}
	
	private String getLastName() {
		return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
	}
	

	private TransactionStatus getTransactionStatus() {
		return TransactionStatus.values()[random.nextInt(TransactionStatus.values().length)];
	}
	
	private Account[] getTwoDifferentAccounts() {
		List<Account> accounts = accountRepository.findAll();
		int indexSender = random.nextInt(accounts.size());
		int indexReceiver = indexSender;
		do {
			indexReceiver = random.nextInt(accounts.size());
		} while(indexReceiver == indexSender);
			
		return new Account[]{accounts.get(indexSender), accounts.get(indexReceiver)};
	}
	

}
