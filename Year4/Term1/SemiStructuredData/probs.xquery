(: let $docs := collection("file:/E:/Coding/University/Year4/SemiStructuredData/files/?select=*xml") :)
let $docs := collection("./files/")

let $pairs :=
    for $s in $docs//s
    for $w in $s/w
    let $next := $w/following-sibling::w[1]
    where lower-case(normalize-space($w)) = 'has'
    return concat(normalize-space(data($w)), ' ', normalize-space(data($next)))

let $results :=
    for $uniquePair in distinct-values($pairs)
    let $target := substring-before($uniquePair, ' ')
    let $successor := substring-after($uniquePair, ' ')
    let $pairFreq := count($pairs[. = $uniquePair])
    let $successorFreq := count($docs//w[lower-case(normalize-space(.)) = lower-case($successor)])
    let $probability := if ($successorFreq > 0) then $pairFreq div $successorFreq else 0
    order by $probability descending, $successor ascending
    (: noted that the output in the spec had "begun" as the first row of output. Assume you did a double sort:)
    return
        <tr>
            <td>{$target}</td>
            <td>{$successor}</td>
            <td>{format-number($probability, '#0.##')}</td>
        </tr>

return
    <table>
        <tr><th>Target</th><th>Successor</th><th>Probability</th></tr>
        {$results}
    </table>
