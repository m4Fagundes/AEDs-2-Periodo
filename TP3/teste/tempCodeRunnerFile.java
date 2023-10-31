public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHeight() { return this.height; }
    public int getWeight() { return this.weight; }
    public String getCollege() { return this.college; }
    public int getYearOfBirth() { return this.yearOfBirth; }
    public String getBirthCity() { return this.birthCity; }
    public String getBirthState() { return this.birthState; }

    // Sets
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setCollege(String college) { this.college = college; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setBirthCity(String birthCity) { this.birthCity = birthCity; }
    public void setBirthState(String birthState) { this.birthState = birthState; }

    // Clone
    public Player clone() { return new Player(this.id, this.name, this.height, this.weight, this.college, this.yearOfBirth, this.birthCity, this.birthState); }

    // Print
    public void print() {

        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
            this.id, this.name, this.height, this.weight, this.yearOfBirth, this.college, this.birthCity, this.birthState);
    }

    // Read
    public void read(String line) {

        // Split line by ","
        String[] splitted = line.split(",", -1);

        // Fill empty attributes
        for(int i = 0; i < splitted.length; i++) {

            if(splitted[i].equals("")) splitted[i] = "nao informado";
        }

        // Set attributes
        this.id = Integer.parseInt(splitted[0]);
        this.name = splitted[1];
        this.height = Integer.parseInt(splitted[2]);
        this.weight = Integer.parseInt(splitted[3]);
        this.college = splitted[4];
        this.yearOfBirth = Integer.parseInt(splitted[5]);
        this.birthCity = splitted[6];
        this.birthState = splitted[7];
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Read all players function
    public static void startPlayers() {

        // Initialize variables
        try {

            FileInputStream fstream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ---------------------- //

            // Explode CSV file
            String line = br.readLine();
  
            while((line = br.readLine()) != null) {

                // Initialize player
                Player player = new Player();

                // Read line
                player.read(line);

                // Add player to array
                allPlayers.add(player);
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Search by id function
    public static Player searchById(int id, ArrayList<Player> players) {

        // Search for player
        for(int i = 0; i < players.size(); i++) {

            if(players.get(i).getId() == id) return players.get(i);
        }
        return null;
    }

    // ---------------------------------------------------------------------------------------------------- //

    public static void main(String[] args) {
        
        // ----------------------------------------------------------------- //

        // #1 - Start - Read all players in CSV file
        startPlayers();

        // ----------------------------------------------------------------- //

        // #2 - Read input and print players from pub.in id entries

        // Initialize scanner
        Scanner inScanner = new Scanner(System.in);

        // Initialize player
        Player player = new Player();

        // Read first line
        String line = inScanner.nextLine();

        // While line is not "FIM"
        while(!line.equals("FIM")) {

            // Get id
            int id = Integer.parseInt(line);

            // Search for player
            player = searchById(id, allPlayers);

            // Print player
            if(player != null) player.print();
            else System.out.println("x Player not found!");

            // Read line
            line = inScanner.nextLine();
        }

        // Close scanner
        inScanner.close();
    }
}

// ---------------------------------------------------------------------------------------------------- //