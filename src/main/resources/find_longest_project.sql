SELECT project_id, (DATE_PART('year', finish_date::date) - DATE_PART('year', start_date::date)) * 12 +
                   (DATE_PART('month', finish_date::date) - DATE_PART('month', start_date::date)) AS month
FROM project
WHERE (SELECT (DATE_PART('year', finish_date::date) - DATE_PART('year', start_date::date)) * 12 +
              (DATE_PART('month', finish_date::date) - DATE_PART('month', start_date::date))) =
      (SELECT MAX((DATE_PART('year', finish_date::date) - DATE_PART('year', start_date::date)) * 12 +
                  (DATE_PART('month', finish_date::date) - DATE_PART('month', start_date::date))) FROM project)