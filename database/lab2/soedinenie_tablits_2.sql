SELECT journal.time_out, journal.time_in, routes.name, auto.num
FROM
  journal
  RIGHT OUTER JOIN
  routes 
    ON journal.route_id = routes.id
  FULL OUTER JOIN
  auto
  	ON journal.auto_id = auto.id
