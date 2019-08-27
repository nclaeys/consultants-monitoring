<#import '_main.ftl' as m>
<@m.page title="Checkins">
<div class="container">
    <div class="row">
        <div class="eight columns" style="margin-top: 30px">
            <h1>List of all checkins</h1>
            <form action="/checkin/" method="POST">
                <input type="text" name="user" placeholder="user">
                <input type="text" name="content" placeholder="content">
                <input type="text" name="year" placeholder="year">
                <input type="text" name="quarter" placeholder="quarter">
                <button type="submit" class="button-primary" onclick='mixpanel.track("feature checkin", {"action": "submit"})'>Create!</button>
            </form>
            <table style="width: 100%">
                <thead>
                    <tr>
                        <th>user</th>
                        <th>content</th>
                        <th>year</th>
                        <th>quarter</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <#list checkins as c>
                    <tr>
                        <td>${c.user}</td>
                        <td>${c.content}</td>
                        <td>${c.year}</td>
                        <td>${c.quarter}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
            <#if !checkins?has_content>
            <div>
                Nothing to show! Yea! Do your first checkin.
            </div>
            </#if>
        </div>
    </div>
</div>

</@m.page>