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

	public enum Seg {
		A, B, C, D, E, F, G,
	}

	public enum Segs {
		ZERO(EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.D, Seg.E, Seg.F)),
		ONE(EnumSet.of(Seg.A, Seg.B)),
		TWO(EnumSet.of(Seg.A, Seg.C, Seg.D, Seg.F, Seg.G)),
		THREE(EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.F, Seg.G)),
		FOUR(EnumSet.of(Seg.A, Seg.B, Seg.E, Seg.G)),
		FIVE(EnumSet.of(Seg.B, Seg.C, Seg.E, Seg.F, Seg.G)),
		SIX(EnumSet.of(Seg.B, Seg.C, Seg.D, Seg.E, Seg.F, Seg.G)),
		SEVEN(EnumSet.of(Seg.A, Seg.B, Seg.E, Seg.F)),
		EIGHT(EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.D, Seg.E, Seg.F, Seg.G)),
		NINE(EnumSet.of(Seg.A, Seg.B, Seg.C, Seg.E, Seg.F, Seg.G));

		public final EnumSet<Seg> flags;

		Segs(EnumSet<Seg> segSet) {
			flags = segSet;
		}

		public static List<Segs> toList() {
			return Arrays.asList(Segs.values());
		}
	}

	@Override
	protected void solve() {
		// TODO 自動生成されたメソッド・スタブ
		testPrint();
	}

	private void testPrint() {
		StringBuilder builder = new StringBuilder();

		Segs.toList().forEach(seg -> builder.append(seg.flags.contains(Seg.F) ? " -   " : "     "));
		builder.append("\r\n");

		Segs.toList().forEach(seg -> {
			builder.append(seg.flags.contains(Seg.E) ? "| " : "  ");
			builder.append(seg.flags.contains(Seg.A) ? "|" : " ");
			builder.append("  ");
		});
		builder.append("\r\n");

		Segs.toList().forEach(seg -> builder.append(seg.flags.contains(Seg.G) ? " -   " : "     "));
		builder.append("\r\n");

		Segs.toList().forEach(seg -> {
			builder.append(seg.flags.contains(Seg.D) ? "| " : "  ");
			builder.append(seg.flags.contains(Seg.B) ? "|" : " ");
			builder.append("  ");
		});
		builder.append("\r\n");

		Segs.toList().forEach(seg -> builder.append(seg.flags.contains(Seg.C) ? " -   " : "     "));
		builder.append("\r\n");

		System.out.println(builder.toString());
	}

}
