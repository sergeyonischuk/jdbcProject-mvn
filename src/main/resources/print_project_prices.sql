SELECT project.project_id,
       SUM(((DATE_PART('year', finish_date::date) - DATE_PART('year', start_date::date)) * 12 +
            (DATE_PART('month', finish_date::date) - DATE_PART('month', start_date::date))) * salary_month) AS price
FROM project
         JOIN project_worker ON project_worker.project_id = project_worker.worker_id
         JOIN worker ON project_worker.worker_id = worker.worker_id
GROUP BY project.project_id
ORDER BY price
    DESC