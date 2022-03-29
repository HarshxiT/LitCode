SELECT S1.score as score, (SELECT COUNT(DISTINCT score) FROM Scores WHERE score >= S1.score) as "rank"
FROM Scores S1
ORDER BY S1.score DESC;