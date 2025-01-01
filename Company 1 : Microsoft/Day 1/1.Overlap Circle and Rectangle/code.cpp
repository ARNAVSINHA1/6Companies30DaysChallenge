class Solution {
public:
    bool checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        auto clamp = [&](int center, int mn, int mx) {
            return max(mn, min(mx, center));
        };
        // the distance between the circle's center and its closest point
        int distanceX = xCenter - clamp(xCenter, x1, x2), distanceY = yCenter - clamp(yCenter, y1, y2);

        // If the distance < the circle's radius, an intersection occurs.
        return ((distanceX * distanceX) + (distanceY * distanceY)) <= (radius * radius);
    }
};
