package japuzzle;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class Q38 extends Question {
	//  -
	// | |     左のような
	//  -      ７セグの数字がある
	// | |
	//  -
	//
	//  F     各セグメントは
	// E A    以下のような記号で表現する。
	//  G
	// D B
	//  C
	//
	// Q. 10 個すべての数字を表示して点灯、消灯の回数が一番少なくなる順番とその時の切り替え回数を求めなさい。
	//
	// * 全通りの組み合わせは 3628800 通り  まずはこの組み合わせを作る
	// * 組み合わせを作ることができたら切り替え回数を求める。
	//   以下のコードで 0 から 1 に切り替えたときの A が変更されたかどうかがわかります。 
	//   SegNum.Zero.flags.contains(Seg.A) ^ SegNum.ONE.flags.contains(Seg.A)
	public enum Seg {
		A, B, C, D, E, F, G,
	}

	public enum SegNum {
		ZERO(0, EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.D, Seg.E, Seg.F)),
		ONE(1, EnumSet.of(Seg.A, Seg.B)),
		TWO(2, EnumSet.of(Seg.A, Seg.C, Seg.D, Seg.F, Seg.G)),
		THREE(3 ,EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.F, Seg.G)),
		FOUR(4, EnumSet.of(Seg.A, Seg.B, Seg.E, Seg.G)),
		FIVE(5, EnumSet.of(Seg.B, Seg.C, Seg.E, Seg.F, Seg.G)),
		SIX(6, EnumSet.of(Seg.B, Seg.C, Seg.D, Seg.E, Seg.F, Seg.G)),
		SEVEN(7, EnumSet.of(Seg.A, Seg.B, Seg.F)),
		EIGHT(8, EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.D, Seg.E, Seg.F, Seg.G)),
		NINE(9, EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.E, Seg.F, Seg.G));

		public final EnumSet<Seg> flags;
		public final int value;
		
		SegNum(int value, EnumSet<Seg> segSet) {
			this.flags = segSet;
			this.value = value;
		}
		
		public static List<SegNum> toList() {
			return Arrays.asList(SegNum.values());
		}
	}

	@Override
	protected void solve() {
		// TODO 自動生成されたメソッド・スタブ
		segPrint(SegNum.toList());
	}

	private void segPrint(List<SegNum> segsList) {
		StringBuilder builder = new StringBuilder();

		segsList.forEach(seg -> builder.append(seg.flags.contains(Seg.F) ? " =   " : "     "));
		builder.append("\r\n");

		segsList.forEach(seg -> {
			builder.append(seg.flags.contains(Seg.E) ? "| " : "  ");
			builder.append(seg.flags.contains(Seg.A) ? "|" : " ");
			
			builder.append("  ");
		});
		builder.append("\r\n");

		segsList.forEach(seg -> builder.append(seg.flags.contains(Seg.G) ? " =   " : "     "));
		builder.append("\r\n");

		segsList.forEach(seg -> {
			builder.append(seg.flags.contains(Seg.D) ? "| " : "  ");
			builder.append(seg.flags.contains(Seg.B) ? "|" : " ");
			builder.append("  ");
		});
		builder.append("\r\n");

		segsList.forEach(seg -> builder.append(seg.flags.contains(Seg.C) ? " =   " : "     "));
		builder.append("\r\n");

		System.out.println(builder.toString());
	}
}
