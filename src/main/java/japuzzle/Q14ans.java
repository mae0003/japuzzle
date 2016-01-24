package japuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q14ans extends Question {

	static List<String> words;
	private int maxCount = 0;

	static {
		words = Arrays.asList(
				"わかめ", "とうふ", "あさり", "みそ", "ずっきーに", "ふりかけ", "にく", "かつお", "きのこ", "だし", "こんぶ",
				"ぶり", "らっぱ", "るねっさんす", "そくらてす", "かるあみるく", "こびと", "しんばる",
				"りんご", "ぱんつ", "めんちかつ", "たにし", "くわ", "けいと", "しんぶん", "どんこにし", "だあすべいだあ",
				"ごりら", "おおくわがた", "りんぼーだんす", "すず", "つばめ", "めだか", "つき"
				);
	}

	@Override
	public void solve() {
		words.forEach(word -> {
			findNextWord(word, new ArrayList<>());
		});
	}

	void findNextWord(String word, List<String> shiritoriWords) {
		List<String> clonedShiritoriWords = new ArrayList<>(shiritoriWords);
		clonedShiritoriWords.add(word);
		words.stream().forEach(nextWord -> {
			if (!clonedShiritoriWords.contains(nextWord) && nextWord.startsWith(word.substring(word.length() - 1))) {
				findNextWord(nextWord, clonedShiritoriWords);
			}
		});

		if (clonedShiritoriWords.size() >= maxCount) {
			maxCount = clonedShiritoriWords.size();
			System.out.println(String.format("[%d]: %s", maxCount, String.join(" - ", clonedShiritoriWords)));

			List<String> hh = new ArrayList<>();
			hh.addAll(words);
			hh.removeAll(clonedShiritoriWords);
			System.out.println(String.format("[使っていない]: %s", String.join(" - ", hh)));
		}

	}

}
