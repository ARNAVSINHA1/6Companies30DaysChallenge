class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int, int>>> graph(n); 
        for (auto& elem : roads) {
            graph[elem[0]].emplace_back(elem[1], elem[2]); 
            graph[elem[1]].emplace_back(elem[0], elem[2]); 
        }
        vector<long> dist(n, LONG_MAX), ways(n, 0); 
        dist[0] = 0; 
        ways[0] = 1; 
        priority_queue<pair<long, int>, vector<pair<long, int>>, greater<>> pq; // min-heap 
        pq.emplace(0, 0); 
        while (pq.size()) {
            auto [d, u] = pq.top(); pq.pop(); 
            if (d > dist.back()) break; 
            if (d == dist[u]) 
                for (auto& [v, time] : graph[u]) {
                    if (dist[u] + time < dist[v]) {
                        dist[v] = dist[u] + time; 
                        ways[v] = ways[u]; 
                        pq.emplace(dist[v], v); 
                    } else if (dist[u] + time == dist[v]) 
                        ways[v] = (ways[v] + ways[u]) % 1'000'000'007; 
                }
        }
        return ways.back(); 
    }
};
