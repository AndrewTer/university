SELECT journal.time_out, routes.name
FROM
  journal  -- Левая таблица
  RIGHT OUTER JOIN
  routes   -- Правая таблица
    ON journal.route_id = routes.id
