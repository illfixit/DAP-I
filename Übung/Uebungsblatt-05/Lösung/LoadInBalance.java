public class LoadInBalance
{
    // ########################################################################
	// Methode aus Vorlesung
	public boolean existsBalance(int[] containers, int limit) {
		return existsBalanceUpTo(containers, limit, 0, 0);
	}
    
    private boolean existsBalanceUpTo(int[] containers, int limit, int divergence, int unitsLoaded) {
		if (unitsLoaded >= containers.length) {
			return true;
		}
		int nextDivergence = divergence + containers[unitsLoaded];
		if (Math.abs(nextDivergence) <= limit) {
			boolean loadedOnPortside = existsBalanceUpTo(containers, limit, nextDivergence, unitsLoaded + 1);
			if (loadedOnPortside) {
				return true;
			}
		}
		nextDivergence = divergence - containers[unitsLoaded];
		if (Math.abs(nextDivergence) <= limit) {
			return existsBalanceUpTo(containers, limit, nextDivergence, unitsLoaded + 1);
		} else {
			return false;
		}
	}
    
    // ########################################################################
	// Aufgabe a
    public boolean existsTotalBalance(int[] containers, int limit)
    {
        return existsTotalBalance(containers, limit, 0, 0);
    }
    
    // Einzige Änderung ist return divergence == 0 anstatt true beim Rekursionsabbruch.
    private boolean existsTotalBalance(int[] containers, int limit, int divergence, int unitsLoaded) {
		if (unitsLoaded >= containers.length) { 
			return divergence == 0; // Abfrage der divergence ist einzige Änderung zu Vorlesungscode
		}
		int nextDivergence = divergence + containers[unitsLoaded];
		if (Math.abs(nextDivergence) <= limit) {
			boolean loadedOnPortside = existsBalanceUpTo(containers, limit, nextDivergence, unitsLoaded + 1);
			if (loadedOnPortside) {
				return true;
			}
		}
		nextDivergence = divergence - containers[unitsLoaded];
		if (Math.abs(nextDivergence) <= limit) {
			return existsBalanceUpTo(containers, limit, nextDivergence, unitsLoaded + 1);
		} else {
			return false;
		}
	}
    
    // ########################################################################
	// Aufgabe b
    // Bei unbegrenzten Laderäumen kann grundsätzlich alles in die Mitte geladen werden.
    // Die divergence bleibt immer 0!
    public boolean existsBalanceWith3Holds(int[] containers, int limit)
    {
		return true;
        //return existsBalanceFor3(containers, limit, 0, 0, 0, 0, Integer.MAX_VALUE);
    }
   
    // ########################################################################
	// Aufgabe c
    // Beschränkter Laderaum für 3 Laderäume. 
    public boolean existsBalabceWith3LimitedHolds(int[] containers, int limit, int containerLimit)
    {
       return existsBalanceFor3(containers, limit, 0, 0, 0, 0, containerLimit);
    }
    
    	// Schiff mit 3 Laderäumen und am Ende divergence == 0
	private boolean existsBalanceFor3(int[] containers, int limit, int divergence, int portsideUnits, int midshipUnits, int starboardUnits, int containerLimit) {
		int unitsLoaded = portsideUnits + starboardUnits + midshipUnits;

		if (unitsLoaded >= containers.length) {
			return divergence == 0;
		}
		if (midshipUnits < containerLimit) { // Standartmäßig in die Mitte -
												// verändert divergence nicht.
												// Nur wenn noch min. ein Platz
												// frei ist
			if (existsBalanceFor3(containers, limit, divergence, portsideUnits, midshipUnits + 1, starboardUnits, containerLimit)) {
				return true;
			}
		}
		if (portsideUnits < containerLimit) { // min. ein Platz noch frei
			int nextDivergence = divergence + containers[unitsLoaded];
			if (Math.abs(nextDivergence) <= limit) { // Balance gefährdet?
				if (existsBalanceFor3(containers, limit, nextDivergence, portsideUnits + 1, midshipUnits, starboardUnits, containerLimit)) {
					return true;
				}
			}
		}
		if (starboardUnits < containerLimit) { // min. ein Platz noch frei
			int nextDivergence = divergence - containers[unitsLoaded];
			if (Math.abs(nextDivergence) <= limit) { // Balance gefährdet?
				return existsBalanceFor3(containers, limit, nextDivergence, portsideUnits, midshipUnits, starboardUnits + 1, containerLimit);
			}
		}
		return false;
	}
    
    // ########################################################################
    // Für ganz viel Langeweile
	// N Laderäume und Divergenz am Ende genau 0
	private boolean existsBalanceForN(int[] containers, int limit, int divergence, int[] unitsLoaded, int containerLimit) {
		int allUnitsLoaded = sum(unitsLoaded);

		if (allUnitsLoaded >= containers.length) {
			return divergence == 0;
		}
		if (unitsLoaded.length % 2 == 1) { // Wenn Anzahl der Laderäume ungerade muss Mitte zuerst beladen werden.
			if (unitsLoaded[unitsLoaded.length / 2] < containerLimit) {
				unitsLoaded[unitsLoaded.length / 2]++;
				if (existsBalanceForN(containers, limit, divergence, unitsLoaded, containerLimit)) {
					return true;
				}
				unitsLoaded[unitsLoaded.length / 2]--;
			}
			for (int i = 1; i <= unitsLoaded.length / 2; i++) {
				allUnitsLoaded = sum(unitsLoaded);
				if (unitsLoaded[unitsLoaded.length / 2 + i] < containerLimit) {
					int nextDivergence = divergence + i * containers[allUnitsLoaded];
					if (Math.abs(nextDivergence) <= limit) { // Balance
																// gefährdet?
						unitsLoaded[unitsLoaded.length / 2 + i]++;
						if (existsBalanceForN(containers, limit, nextDivergence, unitsLoaded, containerLimit)) {
							return true;
						}
						unitsLoaded[unitsLoaded.length / 2 + i]--;
					}
				}
				if (unitsLoaded[unitsLoaded.length / 2 - i] < containerLimit) {
					int nextDivergence = divergence - i * containers[allUnitsLoaded];
					if (Math.abs(nextDivergence) <= limit) { // Balance
																// gefährdet?
						unitsLoaded[unitsLoaded.length / 2 - i]++;
						if (existsBalanceForN(containers, limit, nextDivergence, unitsLoaded, containerLimit)) {
							return true;
						}
						unitsLoaded[unitsLoaded.length / 2 - i]--;
					}
				}
			}
			return false;
		} else {
			for (int i = 1; i <= unitsLoaded.length / 2; i++) {
				if (unitsLoaded[unitsLoaded.length / 2 + i - 1] < containerLimit) {
					int nextDivergence = divergence + i * containers[allUnitsLoaded];
					if (Math.abs(nextDivergence) <= limit) { // Balance
																// gefährdet?
						unitsLoaded[unitsLoaded.length / 2 + i - 1]++;
						if (existsBalanceForN(containers, limit, nextDivergence, unitsLoaded, containerLimit)) {
							return true;
						}
						unitsLoaded[unitsLoaded.length / 2 + i - 1]--;
					}
				}
				if (unitsLoaded[unitsLoaded.length / 2 - i] < containerLimit) {
					int nextDivergence = divergence - i * containers[allUnitsLoaded];
					if (Math.abs(nextDivergence) <= limit) {
						unitsLoaded[unitsLoaded.length / 2 - i]++;
						if (existsBalanceForN(containers, limit, nextDivergence, unitsLoaded, containerLimit)) {
							return true;
						}
						unitsLoaded[unitsLoaded.length / 2 - i]--;
					}
				}
			}
			return false;
		}
	}

    
	private int sum(int[] unitsLoaded) {
		int sum = 0;
		for (int i : unitsLoaded) {
			sum += i;
		}
		return sum;
	}

}
