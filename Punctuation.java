//Xinhui Huang p6
//Punctuation.java
//This program searches for words that have the punctuations(. , ; : ! ?
// ' " ... () -). It will take some	text, read	it	word
//by word and print all	of the words that have some	punctuation	in it.		


public class Punctuation
{
	public static void main(String[] args)
	{
		Punctuation pc = new Punctuation();
		pc.searchIt();
	}
	
	public void searchIt()
	{
		String text = new String("Blood, Sweat, and Tears by Winston Churchill " + "May 13, 1940 " +
									"Mr. Speaker: " + "On Friday evening last I received His Majesty’s commission to form a new " +
									"Administration. It was the evident wish and will of Parliament and the nation that this should be conceived" + 
									" on the broadest possible basis and that it should include all parties, both those who supported the late Government and also the parties of the Opposition. " +
									"I have completed the most important part of this task. A War Cabinet has been formed of five Members, " + 
									"representing, with the Liberal Opposition, the unity of the nation. The three party Leaders have agreed to serve," +
									" either in the War Cabinet or in high executive office. The three Fighting Services have been filled."+
									" It was necessary that this should be done in one single day, on account of the extreme urgency and " +
									"rigour of events. A number of other key positions were filled yesterday, and I am submitting a further list to His Majesty tonight. " +
									"I hope to complete the appointment of the principal Ministers during tomorrow. The appointment of the other Ministers usually" +
									" takes a little longer, but I trust that, when Parliament meets again, this part of my task will be completed, and that the Administration will be complete in all respects. " +
									"Sir, I considered it in the public interest to suggest that the House should be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in"+
									" accordance with the powers conferred upon him by the Resolution of the House. At the end of the proceedings today, the Adjournment of the House will be proposed until " +
									"Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The	business to be considered during that week will be notified to Members at the earliest "+
									"opportunity. I now invite the House, by the Resolution which stands in my name, to record its approval of the steps taken and to declare its confidence in the new Government. " +
									"Sir, to form an Administration of this scale and complexity is a serious undertaking in itself, but it must be remembered that we are in the preliminary stage of "+
									"one of the greatest battles in history, that we are in action at many points in Norway and in Holland, that we have to be prepared in the Mediterranean, that the air battle is "+
									"continuous and that many preparations have to be made here at home. In this crisis I hope I may be pardoned if I do not address the House at any length today. I hope that "+
									"any of my friends and colleagues, or former colleagues, who are affected by the political reconstruction, will make all allowances for any lack of ceremony with which it has been "+
									"necessary to act. I would say to the House, as I said to those who’ve joined this government: \"I have nothing to offer but blood, toil, tears and sweat. \"" +
									"We have before us an ordeal of the most grievous kind. We have before us many, many long months of struggle and of suffering. You ask, what is our policy? I will say: "+
									"It is to wage war, by sea, land and air, with all our might and with all the strength that God can give us; to wage war against a monstrous tyranny, never "+
									"surpassed in the dark and lamentable catalogue of human crime. That is our policy. You ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in "+
									"spite of all terror, victory, however long and hard the road may be; for without victory, there is no survival. Let that be realised; no survival for the British Empire, no survival "+
									"for all that the British Empire has stood for, no survival for the urge and impulse of the ages, that mankind will move forward towards its goal. " +
									"But I take up my task with buoyancy and hope. I feel sure that our cause will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, "+
									"and I say, \"Come then, let us go forward together with our united strength. \"");
		getPunctuationWords(text);
	}
	
	public void getPunctuationWords(String str)
	{
		int lastSpace = -1;
		int space = 0;
		String word = new String("");
		while((space<=str.length()-1)&&(lastSpace<=str.length()-1))
		{
			space = str.indexOf(" ",lastSpace+1);	//find the index of the closest space after previous space
			if(space<0)								//check if the program reaches the end of the paragraph
				break;
			word=str.substring(lastSpace+1,space);	//get each word bewtween two spaces
			lastSpace=space;						//update the index of previous space
			boolean n=checkForPunctuation(word);	//check if the word contains a punctuation
			if(n==true)								//if the word contains a punctuation, print it
				printWords(word);
		}
	}
	
	public void printWords(String input)			//print out the input word that contains punctuation
	{
		System.out.println(input);
	}
	
	public boolean checkForPunctuation(String input)	//check if the input word contains punctuation
	{
		int lastChar = (int)(input.charAt(input.length()-1));	//store the ASCII value of the last character of the word
		int firstChar = (int)(input.charAt(0));					//store the ASCII value of the first character of the word
		if(lastChar>32&&(lastChar<48||(lastChar>57&&lastChar<64)||(lastChar>90&&lastChar<97)||lastChar>122))			//check if the last letter is a punctuation
			return true;
		else if(firstChar>32&&(firstChar<48||(firstChar>57&&firstChar<64)||(firstChar>90&&firstChar<97)||firstChar>122))//check if the first letter is a punctuation
			return true;
		else
			return false;
	}
}
