package japuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Q38ans extends Question {
	
	private int count = 0;
	private int minPoint = 7 * 9;   // 最大でも 63 を超えることがない 
	
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
	// * 

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
		List<SegNum> current = new ArrayList<>();
		createAllPattern(current);
		System.out.println("[" + this.count +  "]");
	}

	private void createAllPattern(List<SegNum> current) {
		SegNum.toList().forEach(item -> {
			if(!current.contains(item)) {
				List<SegNum> clonedCurrent = new ArrayList<>(current); 
				clonedCurrent.add(item);
				createAllPattern(clonedCurrent);
			}
		});
		if (current.size() == 10) {
			this.count++;
			int thisPoint = calculatePoint(current);
			if (thisPoint <=  minPoint) {
				minPoint = thisPoint;
			   System.out.println("[" + thisPoint +  "]" + String.join(" - ", current.stream().map(segs -> String.valueOf(segs.value)).collect(Collectors.toList())));
			   segPrint(current);
			}
		}
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
	
	public int calculatePoint(List<SegNum> segList){
		int point = 0;
		
		for (int i = 0; i < segList.size() - 1; i++) {
			for( Seg seg : Seg.values()) {
				if (segList.get(i).flags.contains(seg) ^ segList.get(i+1).flags.contains(seg)) point++;
			}
		}
		
		return point;
	}
}
