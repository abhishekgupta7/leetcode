
/**
 * 
 * 149. Max Points on a Line
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * https://leetcode.com/problems/max-points-on-a-line/
 * @author abhigupta
 *
 */
import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	public int hashCode() {
		return x + y;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	public boolean equals(Object c) {

		Point p = (Point) c;
		if (p.x == this.x && p.y == this.y) {
			return true;
		}

		return false;

	}
}

class Line {
	public int mx;
	public int my;

	public int c;

	@Override
	public boolean equals(Object c) {

		Line l = (Line) c;

		if (l.mx == this.mx && l.c == this.c && l.my == this.my) {
			return true;
		}

		return false;

	}
}

// 149. Max Points on a Line
public class MaxPointOnLine {

	public int maxPoints(Point[] points) {

		if (points == null || points.length <= 2) {
			return points.length;
		}

		Map<Line, Integer> m = new HashMap<Line, Integer>();

		Map<Point, Integer> count = new HashMap<Point, Integer>();
		int cc = 0;

		for (Point p : points) {

			if (count.containsKey(p)) {
				cc = count.get(p);
				cc++;
			} else {
				cc = 1;
			}
			count.put(p, cc);
		}

		if (count.size() == 1) {

			return count.get(points[0]);
		}
		/*
		 * Point[] pp = new Point[count.size()]; int jj =0; for(Point p :
		 * count.keySet()){ pp[jj] = p; jj++; }
		 */
		Point[] pp = points;
		Point pi = null;
		Point pj = null;

		Set<Line> list = new HashSet<Line>();
		Map<Point, Integer> mapc = new HashMap<Point, Integer>();
		int maxc = Integer.MIN_VALUE;

		for (int i = 0; i < pp.length; i++) {

			for (int j = i + 1; j < pp.length; j++) {

				if (pp[i].equals(pp[j])) {

					continue;
				}
				pi = pp[i];
				pj = pp[j];

				Line l = new Line();
				l.mx = pi.x - pj.x;
				l.my = pi.y - pj.y;

				int gcd = generateGCD(l.mx, l.my);

				if (gcd != 0) {

					l.mx = l.mx / gcd;
					l.my = l.my / gcd;

				}

				l.c = l.mx * pi.y - l.my * pi.x;
				list.add(l);
			}
		}
		int max = Integer.MIN_VALUE;
		// System.out.println(maxc);
		for (int i = 0; i < pp.length; i++) {
			for (Line line : list) {

				if (pp[i].y * line.mx == (line.my * pp[i].x + line.c)) {

					Integer c = m.get(line);
					if (c == null) {
						m.put(line, 1);
						max = Math.max(max, 1);

					} else {
						c = c + 1;// count.get(pp[i]);
						max = Math.max(max, c);

						m.put(line, c);
					}
				}
			}
		}
		/*
		 * 
		 * for (Line line : m.keySet()) { max = Math.max(max, m.get(line));
		 * 
		 * }
		 */
		return Math.max(max, maxc);
	}

	private int generateGCD(int a, int b) {

		if (b == 0)
			return a;
		else
			return generateGCD(b, a % b);

	}

}
