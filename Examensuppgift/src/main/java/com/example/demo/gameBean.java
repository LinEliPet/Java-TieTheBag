package com.example.demo;

public class gameBean {

	private int games = 0;
	private int win = 0;
	private int loss = 0;
	private int tie = 0;
	
	
	public void addResult(String matchResut)
	{
		games += 1;

		switch (matchResut)
		{
		case "Win":
			win += 1;
			break;
		case "Loss":
			loss += 1;
			break;
		case "Tie":
			tie += 1;
			break;
		}
	}

	
	public String toJsonString() {
		String pattern = "{ \"Games Played\": \"%s\", \"Wins\": \"%s\", \"Losses\": \"%s\", \"Ties\": \"%s\" }";

		String out = String.format(pattern, Integer.toString(this.games), this.win, this.loss, this.tie);

		return out;
	}
}