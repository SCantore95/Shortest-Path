package com.example.matrix_shortest_path.Model;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixController {

    @Autowired
    private MatrixService matrixService;

    @PostMapping("/calculateShortestPath")
    public Map<String, Object> calculateShortestPath(@RequestBody Map<String, int[][]> request) {
        int[][] matrix = request.get("matrix");
        Map<String, Object> response = new HashMap<>();
        int[] shortestPathInfo = matrixService.findShortestPath(matrix);
        response.put("shortestPathRow", shortestPathInfo[0]);
        response.put("shortestPathValue", shortestPathInfo[1]);

        int[] rowSums = matrixService.calculateRowSums(matrix);
        response.put("rowSums", rowSums);

        String graph = matrixService.generateGraph(matrix);
        response.put("graph", graph);

        return response;
    }
}
