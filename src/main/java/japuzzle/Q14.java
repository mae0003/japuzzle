package japuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q14 extends Question {
	
	private int maxCount = 0;
	
	// 以下の 34 単語でしりとりをした場合、最大何回続き、それが何通りあるか プログラムを使って求めなさい。
	// 同じ単語は１度しか使えません
	static List<String> words = Arrays.asList(
			"わかめ", "とうふ", "あさり", "みそ", "ずっきーに", "ふりかけ", "にく", "かつお", "きのこ", "だし", "こんぶ",
			"ぶり", "らっぱ", "るねっさんす", "そくらてす", "かるあみるく", "こびと", "しんばる",
			"りんご", "ぱんつ", "めんちかつ", "たにし", "くわ", "けいと", "しんぶん", "どんこにし", "だあすべいだあ",
			"ごりら", "おおくわがた", "りんぼーだんす", "すず", "つばめ", "めだか", "つき"
			);

	@Override
	public void solve() {
		words.forEach( word -> {
			appendNextWord(word, new ArrayList<String>());
		});
	}

	private void appendNextWord(String word, List<String> usedWords) {
		usedWords.add(word);
		words.forEach( nextWord -> {
			if ( nextWord.startsWith(word.substring(word.length() - 1)) 
					&& !usedWords.contains(nextWord)) {
				appendNextWord(nextWord, new ArrayList<String>(usedWords));
			}
		});
		
		if (usedWords.size() >= maxCount) { 
			maxCount = usedWords.size();
			String ans = String.join(" - ", usedWords);
			System.out.println(String.format("[%d]: %s", maxCount, ans ));
		}
	}
}
