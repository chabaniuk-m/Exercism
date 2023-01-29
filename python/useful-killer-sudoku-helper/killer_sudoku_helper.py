import math


def combinations(target, size, exclude):
    if size == 1:
        return [] if target in exclude else [[target]]
    res = []
    all_combs = all_asc_comb(target, size)
    for comb in all_combs:
        skip = False
        for n in exclude:
            if n in comb:
                skip = True
                break
        if skip:
            continue
        res.append(comb)
    return res


def all_asc_comb(target, size, add=0):
    res = []
    if size == 2:
        for a in range(1, math.ceil(target / 2)):
            res.append([a + add, target - a + add])
    else:
        i = 1
        while linear_sum(i, size) <= target:
            for line in all_asc_comb(target - i * size, size - 1, i + add):
                res.append([i + add] + line)
            i += 1
    return res


def linear_sum(first, size):
    return (first + first + size - 1) * size // 2
