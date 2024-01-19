Maximize
        obj: 120 x1 + 170 x2 + 180 x3 + 240 x4

Subject To
        e1: 15 x1 + 20 x2 + 22 x3 + 20 x4 <= 1500
        e2: 30 x1 + 40 x2 + 50 x3 + 60 x4 <= 2000
        e3: x1 + 2 x2 + 2 x3 + 3 x4 <= 100
	e4: 0.4 x1 + 0.4 x2 + 0.4 x3 - 0.6 x4  <= 0
Bounds
        10 <= x1 <= 20
        10 <= x2 <= +Inf
        10 <= x3 <= +Inf
        10 <= x4 <= +Inf
End

