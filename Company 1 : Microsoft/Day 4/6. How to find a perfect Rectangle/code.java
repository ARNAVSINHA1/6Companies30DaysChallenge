class Solution {
  public boolean isRectangleCover(int[][] rectangles) {
    int area = 0,x1 = Integer.MAX_VALUE,y1 = Integer.MAX_VALUE,x2 = Integer.MIN_VALUE,y2 = Integer.MIN_VALUE;
    Set<String> corners = new HashSet<>();
    for (int[] r : rectangles) {
      area += (r[2] - r[0]) * (r[3] - r[1]);
      x1 = Math.min(x1, r[0]);
      y1 = Math.min(y1, r[1]);
      x2 = Math.max(x2, r[2]);
      y2 = Math.max(y2, r[3]);
      String[] points = new String[] {r[0] + " " + r[1],r[0] + " " + r[3],r[2] + " " + r[1],r[2] + " " + r[3]};
      for (final String point : points)
          if (!corners.add(point))
              corners.remove(point);
    }
    if (corners.size() != 4)
      return false;
    if (!corners.contains(x1 + " " + y1) ||!corners.contains(x1 + " " + y2) ||!corners.contains(x2 + " " + y1) ||!corners.contains(x2 + " " + y2))
      return false;
    return area == (x2 - x1) * (y2 - y1);
  }
}
