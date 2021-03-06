package io.github.xenopyax.edj.utils.localiser;

public class Reputation {
	
	public static String getReputationLocalised(int reputation) {
		String repName = "Neutral";
		
		if(reputation >= 90) {
			repName = "Allied";
		}else if(reputation >= 35) {
			repName = "Friendly";
		}else if(reputation >= 4) {
			repName = "Cordinal";
		}else if(reputation >= -90) {
			repName = "Hostile";
		}else if(reputation >= -35) {
			repName = "Unfriendly";
		}else if(reputation < 4) {
			repName = "Neutral";
		}
	
		return repName;
	}

}
