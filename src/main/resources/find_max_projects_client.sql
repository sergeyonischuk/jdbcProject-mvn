SELECT name, COUNT(project.client_id) AS project_count
FROM client
         INNER JOIN project
                    ON client.client_id = project.client_id
GROUP BY name
HAVING COUNT(project.client_id)
           IN (SELECT COUNT(client_id) FROM project
               GROUP BY client_id
               order by count(CLIENT_ID)
                   desc
               LIMIT 1);